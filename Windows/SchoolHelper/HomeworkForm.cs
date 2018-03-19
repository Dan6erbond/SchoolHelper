using System;
using System.IO;
using System.Net;
using System.Windows.Forms;
using Newtonsoft.Json.Linq;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SchoolHelper
{
	public partial class HomeworkForm : Form
	{
		private string homeworkFileURL = "https://api.myjson.com/bins/1h8sp7";
		private List<Homework> homeworks = new List<Homework>();

		public HomeworkForm()
		{
			InitializeComponent();
			LoadTable();
		}

		private void DownloadHomeworkFile()
		{
			string data = string.Empty;

			HttpWebRequest request = (HttpWebRequest)WebRequest.Create(homeworkFileURL);
			request.AutomaticDecompression = DecompressionMethods.GZip | DecompressionMethods.Deflate;

			using (HttpWebResponse response = (HttpWebResponse)request.GetResponse())
			using (Stream stream = response.GetResponseStream())
			using (StreamReader reader = new StreamReader(stream))
			{
				data = reader.ReadToEnd();
			}

			JArray jArray = JArray.Parse(data);
			foreach (JObject o in jArray)
			{
				Homework homework = new Homework(o["datum"].ToString(), o["fach"].ToString(), o["aufgabe"].ToString());
				homeworks.Add(homework);
			}
			UploadHomework();
		}

		public void AddHomework(Homework homework)
		{
			homeworks.Add(homework);
			UploadHomework();
		}

		private void LoadTable()
		{
			DownloadHomeworkFile();

			tableLayoutPanel1.Controls.Clear();

			for (int i = 0; i < homeworks.Count; i++)
			{
				AddHomeworkToTable(homeworks[i], i);
			}
		}

		private void AddHomeworkToTable(Homework homework, int index)
		{
			if (Properties.Settings.Default.username == "Dan6erbond")
			{
				tableLayoutPanel1.ColumnCount = 3;
				Button delete = new Button();
				delete.Text = "DEL " + index;
				delete.Width = 40;
				delete.Click += new EventHandler(RemoveHomework);
				tableLayoutPanel1.Controls.Add(delete);
				tableLayoutPanel1.SetRowSpan(delete, 2);
			}
			Label date = new Label();
			date.Text = homework.datum;
			date.AutoSize = true;
			Label subject = new Label();
			subject.Text = homework.fach;
			subject.AutoSize = true;
			Label job = new Label();
			job.Text = homework.aufgabe;
			job.AutoSize = true;
			job.Padding = new Padding(0, 0, 0, 25);
			tableLayoutPanel1.Controls.Add(date);
			tableLayoutPanel1.Controls.Add(subject);
			tableLayoutPanel1.Controls.Add(job);
			tableLayoutPanel1.SetColumnSpan(job, 2);
		}

		private void RemoveHomework(object sender, EventArgs e)
		{
			Button senderButton;
			int toRemove = 0;
			try
			{
				senderButton = (Button)sender;
				string toRemoveIndex = senderButton.Text.Replace("DEL ", "");
				toRemove = Int32.Parse(toRemoveIndex);
				homeworks.RemoveAt(toRemove);
				UploadHomework();
				LoadTable();
			}
			catch
			{
				return;
			}
		}

		private void UploadHomework()
		{
			homeworks = new HashSet<Homework>(homeworks).ToList();
			homeworks.Sort(delegate (Homework h1, Homework h2) { return h1.getDate().CompareTo(h2.getDate()); });
			JArray jArray = JArray.FromObject(homeworks);
			byte[] bytes = Encoding.UTF8.GetBytes(jArray.ToString());
			HttpWebRequest request = (HttpWebRequest)WebRequest.Create(string.Format(homeworkFileURL));
			request.Method = "PUT";
			request.ContentType = "application/json; charset=utf-8";
			using (var requestStream = request.GetRequestStream())
			{
				requestStream.Write(bytes, 0, bytes.Length);
			}
			var response = (HttpWebResponse)request.GetResponse();
			Console.WriteLine(response.StatusDescription);
		}

		private void label1_Click(object sender, EventArgs e)
		{

		}

		private void btnAdd_Click(object sender, EventArgs e)
		{
			AddHomeworkForm addHomework = new AddHomeworkForm(this);
			addHomework.ShowDialog();
		}
	}
}
