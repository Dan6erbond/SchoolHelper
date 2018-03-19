using System;
using System.Windows.Forms;

namespace SchoolHelper
{
	public partial class LoginForm : Form
	{
		public LoginForm()
		{
			InitializeComponent();
			label4.Visible = false;
		}

		//btnCancel
		private void button1_Click(object sender, EventArgs e)
		{
			Close();
		}

		private void btnAnmelden_Click(object sender, EventArgs e)
		{
			Credential credential = new Credential(textBox1.Text, textBox2.Text);
			if (credential.GetCredentials().Contains(credential))
			{
				Properties.Settings.Default.username = credential.username;
				Properties.Settings.Default.password = credential.password;
				Properties.Settings.Default.subject = credential.GetSubject();
				Properties.Settings.Default.Save();
				Close();
			} else
			{
				label4.Visible = true;
			}
		}
	}
}
