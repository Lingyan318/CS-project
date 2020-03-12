using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Game
{
    
    public partial class Game1 : Form
    {
        int clickTester = 1;
        int timeLeft = 30;
        int current;
        public Game1()
        {
            InitializeComponent();
        }
        private void changer() 
        {
            label4.ForeColor = System.Drawing.Color.Green;
            label4.Text = "Good!";
            current = clickTester;
            label1.Text = Convert.ToString(Convert.ToInt32(label1.Text) + 2);
            Random r = new Random();
            clickTester = r.Next(1, 7);
            while(current == clickTester)
            {
                clickTester = r.Next(1, 7);
            }
            switch (clickTester)
            {
                case 1:
                    button1.BackColor = System.Drawing.Color.Red;
                    break;
                case 2:
                    button2.BackColor = System.Drawing.Color.Red;
                    break;
                case 3:
                    button3.BackColor = System.Drawing.Color.Red;
                    break;
                case 4:
                    button4.BackColor = System.Drawing.Color.Red;
                    break;
                case 5:
                    button5.BackColor = System.Drawing.Color.Red;
                    break;
                case 6:
                    button6.BackColor = System.Drawing.Color.Red;
                    break;

            }
            
        }
        private void label() 
        {
            label4.ForeColor = System.Drawing.Color.Red;
            label4.Text = "Bad!";
            label1.Text = Convert.ToString(Convert.ToInt32(label1.Text) - 2);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (clickTester == 1)
            {              
                button1.BackColor = SystemColors.Control;
                changer();

            }
            else
            {
                label();
            }      
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            if (clickTester == 2)
            {
                button2.BackColor = SystemColors.Control;
                changer();

            }
            else
            {
                label();
            }
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            if (clickTester == 3)
            {
                button3.BackColor = SystemColors.Control;
                changer();

            }
            else
            {
                label();
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            if (clickTester == 4)
            {
                button4.BackColor = SystemColors.Control;
                changer();

            }
            else
            {
                label();
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            if (clickTester == 5)
            {
                button5.BackColor = SystemColors.Control;
                changer();

            }
            else
            {
                label();
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            if (clickTester == 6)
            {
                button6.BackColor = SystemColors.Control;
                changer();

            }
            else
            {
                label();
            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (timeLeft > 0)
            {
                timeLeft = timeLeft - 1;
                label2.Text = timeLeft + " seconds";

            }
            else
            {
                timer1.Stop();
                MessageBox.Show("your score is " + label1.Text);
                label1.Text = "0";
            }       
         }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button7_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            timeLeft = 31;
            timer1.Start();
            label1.Text = "0";
        }

        private void fileToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void closeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void game2ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game2 form1 = new Game2();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void reStartToolStripMenuItem_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            this.Hide();
            Menu form1 = new Menu();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void Game1_MouseClick(object sender, MouseEventArgs e)
        {
            label();
        }

        private void game1ToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void game4ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game4 form1 = new Game4();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void game5ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game5 form1 = new Game5();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void reTryToolStripMenuItem_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            timeLeft = 31;
            timer1.Start();
            label1.Text = "0";
        }
    }
}
