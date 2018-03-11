using System;
using System.Windows.Forms;

namespace SchoolHelper
{
	public partial class MainForm : Form
	{

		public static double version = 0.1;

		public MainForm()
		{
			InitializeComponent();
			Icon = new System.Drawing.Icon("ic_launcher-web.ico");
			label2.Text = "v" + version;
		}

		private void label1_Click(object sender, EventArgs e)
		{

		}

		private void btnHomework_Click(object sender, EventArgs e)
		{
			HomeworkForm homework = new HomeworkForm();
			homework.ShowDialog();
		}
	}
}
