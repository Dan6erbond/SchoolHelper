using System;
using System.IO;
using System.Net;
using System.Windows.Forms;
using Newtonsoft.Json.Linq;
using System.Collections.Generic;
using System.Linq;

namespace SchoolHelper
{
	public partial class HomeworkForm : Form
	{
		private string homeworkFilePath = Environment.CurrentDirectory + "\\Hausaufgaben.json";
		private List<Homework> homeworks = new List<Homework>();
		private NetworkCredential credentials = new NetworkCredential("dan6erbond_I1A", "I1A_2017_18");

		public HomeworkForm()
		{
			InitializeComponent();
			Icon = new System.Drawing.Icon("ic_launcher-web.ico");
			DownloadHomeworkFile();
			OpenHomeworkFile();
		}

		private void DownloadHomeworkFile()
		{
			WebClient request = new WebClient();
			byte[] fileData = request.DownloadData("http://dan6erbond.bplaced.net/Hausaufgaben.json");
			FileStream file = File.Create(homeworkFilePath);
			file.Write(fileData, 0, fileData.Length);
			file.Close();
		}

		private void OpenHomeworkFile()
		{
			string[] contentArray = File.ReadAllLines(homeworkFilePath);
			string content = String.Join("", contentArray);
			JArray jArray = JArray.Parse(content);
			foreach (JObject o in jArray)
			{
				Homework homework = new Homework(o["datum"].ToString(), o["fach"].ToString(), o["aufgabe"].ToString());
				homeworks.Add(homework);
			}

			homeworks.Sort(delegate (Homework h1, Homework h2) { return h1.getDate().CompareTo(h2.getDate()); });
			homeworks = new HashSet<Homework>(homeworks).ToList();
			UploadHomeworkFile();

			foreach (Homework homework in homeworks)
			{
				AddHomeworkToTable(homework);
			}
		}

		public void AddHomework(Homework homework)
		{
			homeworks.Add(homework);
			homeworks.Sort(delegate (Homework h1, Homework h2) { return h1.getDate().CompareTo(h2.getDate()); });
			homeworks = new HashSet<Homework>(homeworks).ToList();
			UploadHomeworkFile();
			AddHomeworkToTable(homework);
		}

		private void AddHomeworkToTable(Homework homework)
		{
			Label date = new Label();
			date.Text = homework.datum;
			date.AutoSize = true;
			Label subject = new Label();
			subject.Text = homework.fach;
			subject.AutoSize = true;
			Label job = new Label();
			job.Text = homework.aufgabe;
			job.AutoSize = true;
			job.Padding = new Padding(0, 0, 0, 10);
			tableLayoutPanel1.Controls.Add(date);
			tableLayoutPanel1.Controls.Add(subject);
			tableLayoutPanel1.Controls.Add(job);
			tableLayoutPanel1.SetColumnSpan(job, 2);
		}

		private void UploadHomeworkFile()
		{
			//Write list to file
			JArray jArray = JArray.FromObject(homeworks);
			using (var writer = new StreamWriter(homeworkFilePath))
			{
				writer.WriteLine(jArray.ToString());
			}

			//Upload file to FTP
			FtpWebRequest request = (FtpWebRequest)WebRequest.Create("ftp://dan6erbond.bplaced.net/Hausaufgaben.json");
			request.Method = WebRequestMethods.Ftp.UploadFile;
			request.Credentials = credentials;
			Stream ftpStream = request.GetRequestStream();
			FileStream file = File.OpenRead(homeworkFilePath);
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			do
			{
				bytesRead = file.Read(buffer, 0, 1024);
				ftpStream.Write(buffer, 0, bytesRead);
			} while (bytesRead != 0);
			file.Close();
			ftpStream.Close();
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
