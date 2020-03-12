namespace Game
{
    partial class Game2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.label3 = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.reStartToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.game1ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.game2ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.game3ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.game4ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.game5ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.reTryToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.helpToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(66, 281);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Score";
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Red;
            this.button1.Location = new System.Drawing.Point(91, 57);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(10, 10);
            this.button1.TabIndex = 2;
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 281);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(13, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "0";
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(237, 281);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(35, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "label3";
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(129, 276);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 5;
            this.button2.Text = "Retry";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(126, 260);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(52, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "feedback";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.helpToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(298, 25);
            this.menuStrip1.TabIndex = 7;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileToolStripMenuItem
            // 
            this.fileToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.reStartToolStripMenuItem,
            this.menuToolStripMenuItem,
            this.reTryToolStripMenuItem});
            this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
            this.fileToolStripMenuItem.Size = new System.Drawing.Size(39, 21);
            this.fileToolStripMenuItem.Text = "File";
            // 
            // reStartToolStripMenuItem
            // 
            this.reStartToolStripMenuItem.Name = "reStartToolStripMenuItem";
            this.reStartToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.reStartToolStripMenuItem.Text = "ReStart";
            this.reStartToolStripMenuItem.Click += new System.EventHandler(this.reStartToolStripMenuItem_Click);
            // 
            // menuToolStripMenuItem
            // 
            this.menuToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.game1ToolStripMenuItem,
            this.game2ToolStripMenuItem,
            this.game3ToolStripMenuItem,
            this.game4ToolStripMenuItem,
            this.game5ToolStripMenuItem});
            this.menuToolStripMenuItem.Name = "menuToolStripMenuItem";
            this.menuToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.menuToolStripMenuItem.Text = "Menu";
            // 
            // game1ToolStripMenuItem
            // 
            this.game1ToolStripMenuItem.Name = "game1ToolStripMenuItem";
            this.game1ToolStripMenuItem.Size = new System.Drawing.Size(121, 22);
            this.game1ToolStripMenuItem.Text = "Game 1";
            this.game1ToolStripMenuItem.Click += new System.EventHandler(this.game1ToolStripMenuItem_Click);
            // 
            // game2ToolStripMenuItem
            // 
            this.game2ToolStripMenuItem.Name = "game2ToolStripMenuItem";
            this.game2ToolStripMenuItem.Size = new System.Drawing.Size(121, 22);
            this.game2ToolStripMenuItem.Text = "Game 2";
            // 
            // game3ToolStripMenuItem
            // 
            this.game3ToolStripMenuItem.Name = "game3ToolStripMenuItem";
            this.game3ToolStripMenuItem.Size = new System.Drawing.Size(121, 22);
            this.game3ToolStripMenuItem.Text = "Game 3";
            // 
            // game4ToolStripMenuItem
            // 
            this.game4ToolStripMenuItem.Name = "game4ToolStripMenuItem";
            this.game4ToolStripMenuItem.Size = new System.Drawing.Size(121, 22);
            this.game4ToolStripMenuItem.Text = "Game 4";
            this.game4ToolStripMenuItem.Click += new System.EventHandler(this.game4ToolStripMenuItem_Click);
            // 
            // game5ToolStripMenuItem
            // 
            this.game5ToolStripMenuItem.Name = "game5ToolStripMenuItem";
            this.game5ToolStripMenuItem.Size = new System.Drawing.Size(121, 22);
            this.game5ToolStripMenuItem.Text = "Game 5";
            this.game5ToolStripMenuItem.Click += new System.EventHandler(this.game5ToolStripMenuItem_Click);
            // 
            // reTryToolStripMenuItem
            // 
            this.reTryToolStripMenuItem.Name = "reTryToolStripMenuItem";
            this.reTryToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.reTryToolStripMenuItem.Text = "ReTry";
            this.reTryToolStripMenuItem.Click += new System.EventHandler(this.reTryToolStripMenuItem_Click);
            // 
            // helpToolStripMenuItem
            // 
            this.helpToolStripMenuItem.Name = "helpToolStripMenuItem";
            this.helpToolStripMenuItem.Size = new System.Drawing.Size(52, 21);
            this.helpToolStripMenuItem.Text = "Close";
            this.helpToolStripMenuItem.Click += new System.EventHandler(this.helpToolStripMenuItem_Click);
            // 
            // Game2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(298, 303);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Game2";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Game2";
            this.Load += new System.EventHandler(this.Game2_Load);
            this.MouseClick += new System.Windows.Forms.MouseEventHandler(this.Game2_MouseClick);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem reStartToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem menuToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem game1ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem game2ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem helpToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem reTryToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem game3ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem game4ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem game5ToolStripMenuItem;
    }
}