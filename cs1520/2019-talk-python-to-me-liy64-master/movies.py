class Media:
    def __init__(self, title):
        self.title = title

    def slug(self):
        output = ''
        a = '''!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~'''
        for title in self.title.lower():
            if title in a:
                title = ''
            if title == ' ':
                title = '-'
            output = output + title
        return output


class Movie(Media):
    def __init__(self, title, year, director, runtime):
        super(Movie, self).__init__(title)
        self.year = year
        self.director = director
        self.runtime = runtime

    def __repr__(self):
        return '<Movie: %s>' % self.title

    def __str__(self):
        return '('+str(self.year)+')'+self.title

    def abbreviation(self):
        output = ''
        a = '''!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~'''
        for title in self.title.lower():
            if title in a:
                title = ''
            if title == ' ':
                title = '-'
            output = output + title
        return output[0:3]


def director(msg):
    def newfunction(func):
        def function_name(*args, **kwargs):
            if len(args) != 0 and type(args[0]) == int:
                print("=====\n%s \n=====" % (msg + str(args[0])))

            else:
                print("=====\n%s \n=====" % msg)

            func(*args, **kwargs)
        return function_name
    return newfunction


@director('before_year ')
def before_year(year):
    for movie in movies:
        if movie.year < year:
            print(movie)


@director('abbreviation')
def abbr():
    for movie in movies:
        print(movie.abbreviation())


@director('slugs')
def slugs():
    for movie in movies:
        print(movie.slug())


def main():
    print('Thanks for checking the Local Movie Database!')
    slugs()
    abbr()
    before_year(2019)
    print('Thank you')


if __name__ == '__main__':
    movies = [Movie('$$your father$[][]{}', 2023, 'Alex', 100),
              Movie('###LONG ISLAND!####', 2022, 'Jack', 96),
              Movie('!Hello kitty!', 2011, 'Mary', 250),
              Movie('(You\Me)', 1994, 'John', 120),
              Movie('JackyLove', 1993, 'Kitty', 150)]
    main()