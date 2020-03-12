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
    public partial class Menu : Form
    {
        public Menu()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Hide();
           Game1 form1= new Game1();
           form1.ShowDialog();
           form1 = null;
           Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game2 form1 = new Game2();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game1 form1 = new Game1();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game4 form1 = new Game4();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game5 form1 = new Game5();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
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

        private void game1ToolStripMenuItem_Click(object sender, EventArgs e)
        {
           
            this.Hide();
            Game1 form1 = new Game1();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void Menu_MouseClick(object sender, MouseEventArgs e)
        {

        }

        private void game5ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game5 form1 = new Game5();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }

        private void game4ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            Game4 form1 = new Game4();
            form1.ShowDialog();
            form1 = null;
            Application.Exit();
        }
    }
}
