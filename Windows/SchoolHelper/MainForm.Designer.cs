namespace SchoolHelper
{
	partial class MainForm
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
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
			this.label1 = new System.Windows.Forms.Label();
			this.btnHomework = new System.Windows.Forms.Button();
			this.label2 = new System.Windows.Forms.Label();
			this.btnAnmelden = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(238)))), ((int)(((byte)(238)))), ((int)(((byte)(238)))));
			this.label1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label1.ForeColor = System.Drawing.SystemColors.ControlText;
			this.label1.Location = new System.Drawing.Point(0, 0);
			this.label1.Name = "label1";
			this.label1.Padding = new System.Windows.Forms.Padding(0, 10, 0, 0);
			this.label1.Size = new System.Drawing.Size(334, 386);
			this.label1.TabIndex = 0;
			this.label1.Text = "SchoolHelper";
			this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
			this.label1.Click += new System.EventHandler(this.label1_Click);
			// 
			// btnHomework
			// 
			this.btnHomework.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(138)))), ((int)(((byte)(101)))));
			this.btnHomework.FlatAppearance.BorderColor = System.Drawing.Color.White;
			this.btnHomework.FlatAppearance.BorderSize = 0;
			this.btnHomework.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnHomework.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.btnHomework.ForeColor = System.Drawing.Color.White;
			this.btnHomework.Location = new System.Drawing.Point(99, 69);
			this.btnHomework.Name = "btnHomework";
			this.btnHomework.Size = new System.Drawing.Size(135, 23);
			this.btnHomework.TabIndex = 2;
			this.btnHomework.Text = "HAUSAUFGABEN";
			this.btnHomework.UseVisualStyleBackColor = false;
			this.btnHomework.Click += new System.EventHandler(this.btnHomework_Click);
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(13, 361);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(35, 13);
			this.label2.TabIndex = 3;
			this.label2.Text = "label2";
			// 
			// btnAnmelden
			// 
			this.btnAnmelden.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(138)))), ((int)(((byte)(101)))));
			this.btnAnmelden.FlatAppearance.BorderColor = System.Drawing.Color.White;
			this.btnAnmelden.FlatAppearance.BorderSize = 0;
			this.btnAnmelden.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnAnmelden.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.btnAnmelden.ForeColor = System.Drawing.Color.White;
			this.btnAnmelden.Location = new System.Drawing.Point(233, 351);
			this.btnAnmelden.Name = "btnAnmelden";
			this.btnAnmelden.Size = new System.Drawing.Size(89, 23);
			this.btnAnmelden.TabIndex = 4;
			this.btnAnmelden.Text = "ANMELDEN";
			this.btnAnmelden.UseVisualStyleBackColor = false;
			this.btnAnmelden.Click += new System.EventHandler(this.btnAnmelden_Click);
			// 
			// MainForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(334, 386);
			this.Controls.Add(this.btnAnmelden);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.btnHomework);
			this.Controls.Add(this.label1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MaximizeBox = false;
			this.Name = "MainForm";
			this.Text = "Main";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Button btnHomework;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Button btnAnmelden;
	}
}