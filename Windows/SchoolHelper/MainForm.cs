using System;
using System.Windows.Forms;

namespace SchoolHelper
{
	public partial class MainForm : Form
	{
		public static double version = 0.4;

		public MainForm()
		{
			InitializeComponent();
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

		private void btnAnmelden_Click(object sender, EventArgs e)
		{
			LoginForm login = new LoginForm();
			login.ShowDialog();
		}
	}
}
