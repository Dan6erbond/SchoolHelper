namespace SchoolHelper
{
	partial class AddHomeworkForm
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
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.label3 = new System.Windows.Forms.Label();
			this.txtBoxSubject = new System.Windows.Forms.TextBox();
			this.txtBoxJob = new System.Windows.Forms.TextBox();
			this.pickerDate = new System.Windows.Forms.DateTimePicker();
			this.label4 = new System.Windows.Forms.Label();
			this.btnAdd = new System.Windows.Forms.Button();
			this.btnCancel = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(12, 15);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(38, 13);
			this.label1.TabIndex = 0;
			this.label1.Text = "Datum";
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(12, 52);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(31, 13);
			this.label2.TabIndex = 1;
			this.label2.Text = "Fach";
			// 
			// label3
			// 
			this.label3.AutoSize = true;
			this.label3.Location = new System.Drawing.Point(12, 93);
			this.label3.Name = "label3";
			this.label3.Size = new System.Drawing.Size(47, 13);
			this.label3.TabIndex = 2;
			this.label3.Text = "Aufgabe";
			// 
			// txtBoxSubject
			// 
			this.txtBoxSubject.Location = new System.Drawing.Point(118, 49);
			this.txtBoxSubject.Name = "txtBoxSubject";
			this.txtBoxSubject.Size = new System.Drawing.Size(100, 20);
			this.txtBoxSubject.TabIndex = 4;
			// 
			// txtBoxJob
			// 
			this.txtBoxJob.Location = new System.Drawing.Point(118, 90);
			this.txtBoxJob.Name = "txtBoxJob";
			this.txtBoxJob.Size = new System.Drawing.Size(100, 20);
			this.txtBoxJob.TabIndex = 5;
			// 
			// pickerDate
			// 
			this.pickerDate.Location = new System.Drawing.Point(118, 9);
			this.pickerDate.Name = "pickerDate";
			this.pickerDate.Size = new System.Drawing.Size(200, 20);
			this.pickerDate.TabIndex = 6;
			// 
			// label4
			// 
			this.label4.AutoSize = true;
			this.label4.ForeColor = System.Drawing.Color.Red;
			this.label4.Location = new System.Drawing.Point(240, 52);
			this.label4.Name = "label4";
			this.label4.Size = new System.Drawing.Size(137, 13);
			this.label4.TabIndex = 7;
			this.label4.Text = "Kein gültiges Fach gewählt!";
			// 
			// btnAdd
			// 
			this.btnAdd.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(138)))), ((int)(((byte)(101)))));
			this.btnAdd.FlatAppearance.BorderColor = System.Drawing.Color.White;
			this.btnAdd.FlatAppearance.BorderSize = 0;
			this.btnAdd.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnAdd.Location = new System.Drawing.Point(204, 160);
			this.btnAdd.Name = "btnAdd";
			this.btnAdd.Size = new System.Drawing.Size(135, 23);
			this.btnAdd.TabIndex = 8;
			this.btnAdd.Text = "Hinzufügen";
			this.btnAdd.UseVisualStyleBackColor = false;
			this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
			// 
			// btnCancel
			// 
			this.btnCancel.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(138)))), ((int)(((byte)(101)))));
			this.btnCancel.FlatAppearance.BorderColor = System.Drawing.Color.White;
			this.btnCancel.FlatAppearance.BorderSize = 0;
			this.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnCancel.Location = new System.Drawing.Point(50, 160);
			this.btnCancel.Name = "btnCancel";
			this.btnCancel.Size = new System.Drawing.Size(135, 23);
			this.btnCancel.TabIndex = 9;
			this.btnCancel.Text = "Abbrechen";
			this.btnCancel.UseVisualStyleBackColor = false;
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			// 
			// AddHomeworkForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(402, 195);
			this.Controls.Add(this.btnCancel);
			this.Controls.Add(this.btnAdd);
			this.Controls.Add(this.label4);
			this.Controls.Add(this.pickerDate);
			this.Controls.Add(this.txtBoxJob);
			this.Controls.Add(this.txtBoxSubject);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Name = "AddHomeworkForm";
			this.Text = "AddHomeworkForm";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.TextBox txtBoxSubject;
		private System.Windows.Forms.TextBox txtBoxJob;
		private System.Windows.Forms.DateTimePicker pickerDate;
		private System.Windows.Forms.Label label4;
		private System.Windows.Forms.Button btnAdd;
		private System.Windows.Forms.Button btnCancel;
	}
}