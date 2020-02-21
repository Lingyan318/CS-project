import json
import sys
import requests
from math import cos, asin, sqrt

baseURL = sys.argv[1]
command = sys.argv[2]
a = '/station_status.json'
b = '/station_information.json'
sum =0


def distance(lat1, lon1, lat2, lon2):
    p = 0.017453292519943295
    a = 0.5 - cos((float(lat2) - float(lat1)) * p) / 2 + cos(float(lat1) * p) * cos(float(lat2) * p) * (
            1 - cos((float(lon2) - float(lon1)) * p)) / 2
    return 12742 * asin(sqrt(a))


if command == 'total_bikes':
    if len(sys.argv) == 3:
        data = json.loads(requests.get(baseURL + a).content)
        data = data['data']['stations']
        for i in data:
            sum = i['num_bikes_available'] + sum
        print("command =", command)
        print("output=", sum)
    else:
        print('*************Error***************')
        print('Please only enter the URL and command.')

if command == 'total_docks':
    if len(sys.argv) == 3:
        data = json.loads(requests.get(baseURL + a).content)
        data = data['data']['stations']
        for i in data:
            sum = i['num_docks_available'] + sum
        print("command = ", command)
        print("output = ", sum)
    else:
        print('*************Error***************')
        print('Please only enter the URL and command.')

if command == 'percent_avail':
    if len(sys.argv) == 4:
        parameters = sys.argv[3]
        perc = 0
        data = json.loads(requests.get(baseURL + a).content)
        data = data['data']['stations']
        for i in data:
            if i["station_id"] == parameters:
                sum = i['num_bikes_available'] + i['num_docks_available']
                perc = i['num_docks_available'] / sum
        print("command =", command)
        print("parameters =", parameters)
        print("output = ", "{:.0%}".format(perc))
    else:
        print('***************Error***************')
        print('Please only enter the URL, command and station_id.')

if command == 'closest_stations':
    if len(sys.argv) == 5:
        parameters = sys.argv[3]
        parameters1 = sys.argv[4]
        print('command = ', command)
        print('parameters = ', parameters, parameters1)
        dis = 0
        li = []
        data = json.loads(requests.get(baseURL + b).content)
        data = data['data']['stations']
        for i in data:
            dis = distance(parameters, parameters1, i['lat'], i['lon'])
            li.append([dis, i['station_id'], i['name']])
        li.sort()
        print('output =')
        for r in [0, 1, 2]:
            print(li[r][1] + ', ' + li[r][2])
    else:
        print('***************Error***************')
        print('Please only enter the URL, command, latitude and longtitude.')

if command == 'closest_bike':
    if len(sys.argv) == 5:
        parameters = sys.argv[3]
        parameters1 = sys.argv[4]
        print('command = ', command)
        print('parameters = ', parameters, parameters1)
        dis = 0
        li = []
        li1 = []
        data = json.loads(requests.get(baseURL + b).content)
        data = data['data']['stations']
        data2 = json.loads(requests.get(baseURL + a).content)
        data2 = data2['data']['stations']
        for i1 in data:
            dis = distance(parameters, parameters1, i1['lat'], i1['lon'])
            li.append((dis, i1['station_id'], i1['name']))
        li.sort()
        lis = []
        for i2 in range(len(li)):
            for i3 in data2:
                if li[i2][1] == i3['station_id']:
                    lis.append([li[i2][0], li[i2][1], li[i2][2], i3['num_bikes_available']])
        r = 0
        while r < len(lis):
            if lis[r][2] != 0:
                print('output = ', lis[r][1] + ',' + lis[r][2])
                break
    else:
        print('***************Error***************')
        print('Please only enter the URL, command, latitude and longtitude.')
