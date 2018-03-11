using System;

namespace SchoolHelper
{
	public class Homework
	{

		public String datum;
		public String fach;
		public String aufgabe;

		public Homework(String d, String s, String j)
		{
			datum = d;
			fach = s;
			aufgabe = j;
		}

		public DateTime getDate()
		{
			return DateTime.ParseExact(datum, "dd.MM.yyyy", System.Globalization.CultureInfo.InvariantCulture);
		}

		public override bool Equals(object o)
		{
			Homework otherHomework;
			try
			{
				otherHomework = (Homework)o;
			}
			catch
			{
				return false;
			}
			if (otherHomework.datum == datum && otherHomework.fach == fach && otherHomework.aufgabe == aufgabe)
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
