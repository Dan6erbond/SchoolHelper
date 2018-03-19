using System.Collections.Generic;

namespace SchoolHelper
{
	public class Credential
	{
		public string username;
		public string password;

		public Credential(string u, string p)
		{
			username = u;
			password = p;
		}

		public List<Credential> GetCredentials()
		{
			List <Credential> credentials = new List<Credential>();
			credentials.Add(new Credential("Dan6erbond", "Ravi!MoaR"));
			credentials.Add(new Credential("Dan6erbond_I1A", "I1A_2017_18"));
			credentials.Add(new Credential("Daniel Schneeberger", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Peter Sutter", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Lil Klink", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Arleo Loredana", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Graf Matthias", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Blanc Daniel", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Bundi Markus", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Alexander Flick", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Lars Meyer", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Guignard Marielle", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Claudia Wyler", "I1A_Lehrer_2017_18"));
			credentials.Add(new Credential("Jäger Hans", "I1A_Lehrer_2017_18"));
			return credentials;
		}

		public string GetSubject()
		{
			switch (username){
				case "Daniel Schneeberger":
					return "Wirtschaft und Recht";
				case "Peter Sutter":
					return "Geschichte";
				case "Lil Klink":
					return "Finanz- und Rechnungswesen";
				case "Arleo Loredana":
					return "Französisch";
				case "Graf Matthias":
					return "Mathematik";
				case "Blanc Daniel":
					return "ETEU: Biologie";
				case "Bundi Markus":
					return "Deutsch";
				case "Alexander Flick":
					return "Informatik";
				case "Lars Meyer":
					return "Informatik";
				case "Guignard Marielle":
					return "Englisch";
				case "Claudia Wyler":
					return "ETEU: Chemie";
				case "Jäger Hans":
					return "ETEU: Geografie";
				default:
					return "";
			}
		}

		public override bool Equals(object o)
		{
			Credential otherCredential;
			try
			{
				otherCredential = (Credential)o;
			}
			catch
			{
				return false;
			}
			if (otherCredential.username == username && otherCredential.password == password)
				return true;
			else
				return false;
		}

		public override int GetHashCode()
		{
			return 1;
		}
	}
}