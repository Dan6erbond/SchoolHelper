using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SchoolHelper
{
	public partial class AddHomeworkForm : Form
	{

		private HomeworkForm parentForm;

		public AddHomeworkForm(HomeworkForm pf)
		{
			InitializeComponent();
			Icon = new System.Drawing.Icon("ic_launcher-web.ico");
			label4.Visible = false;
			parentForm = pf;
		}

		private void btnAdd_Click(object sender, EventArgs e)
		{
			List <string> subjects = new List<string> { "Deutsch", "Englisch", "ETEU: Biologie", "ETEU: Chemie", "ETEU: Geografie", "Finanz- und Rechnungswesen", "Französisch", "Geschichte", "Mathematik", "Informatik", "Wirtschaft und Recht" };
			if (!subjects.Contains(txtBoxSubject.Text))
			{
				label4.Visible = true;
			} else
			{
				Homework h = new Homework(pickerDate.Value.ToString("dd.MM.yyyy"), txtBoxSubject.Text, txtBoxJob.Text);
				parentForm.AddHomework(h);
				Close();
			}

		}

		private void btnCancel_Click(object sender, EventArgs e)
		{
			Close();
		}
	}
}
