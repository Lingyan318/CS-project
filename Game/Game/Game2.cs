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
    public partial class Game2 : Form
    {
        int x;
        int y;
        int time = 30;
        public Game2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            label4.ForeColor = System.Drawing.Color.Green;
            label4.Text = "Good!";
            Random r = new Random();
            x = r.Next(12, 276);
            y = r.Next(27, 246);
            button1.Location = new Point(x,y);
            label2.Text = Convert.ToString(Convert.ToInt32(label2.Text) + 2);
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            time = time - 1;
            label3.Text = Convert.ToString(time);
            if (time == 0) {
                timer1.Stop();
                MessageBox.Show("Your score is " + label2.Text);
            }
        }

        private void Game2_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            label2.Text = "0";
            timer1.Stop();
            time = 30;
            timer1.Start();
        }

        private void Game2_MouseClick(object sender, MouseEventArgs e)
        {
            label4.ForeColor = System.Drawing.Color.Red;
            label4.Text = "Bad!";
            label2.Text = Convert.ToString(Convert.ToInt32(label2.Text) + -2);
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void helpToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void game1ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            this.Hide();
            Game1 form1 = new Game1();
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

        private void game4ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            this.Hide();
            Game4 form1 = new Game4();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void game5ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            timer1.Stop();
            this.Hide();
            Game5 form1 = new Game5();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void reTryToolStripMenuItem_Click(object sender, EventArgs e)
        {
            label2.Text = "0";
            timer1.Stop();
            time = 30;
            timer1.Start();
        }
    }
}
