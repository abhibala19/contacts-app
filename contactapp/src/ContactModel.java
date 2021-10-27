import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class ContactModel {

	public boolean checkContactBooknameExists(String contactBookName) {
		return new File(contactBookName + ".tocall").exists();

	}

	public void removeContact(String contactName, String contactBookName) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		List<String> l = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] a = line.split(":");
				if (!a[0].equalsIgnoreCase(contactName))
					l.add(line);
			}
			bw = new BufferedWriter(new FileWriter(contactBookName + ".tocall"));

			for (String s : l) {
				bw.write(s);
				bw.newLine();
			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public ContactBean getOneContact(String contactName, String contactBookName) {

		ContactBean contact = null;
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
			while ((line = br.readLine()) != null) {
				String[] a = line.split(":");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				List<String> mail = new ArrayList<String>();
				List<String> phNo = new ArrayList<String>();
				String f = a[5];
				String g = a[6];

				mail = ContactUtil.convertToList(f.substring(1, f.length() - 1));
				phNo = ContactUtil.convertToList(g.substring(1, g.length() - 1));
				if (a[0].equals(contactName)) {

					contact = new ContactBean(a[0], a[1], a[2], a[3], a[4], mail, phNo);

				}
			}
			return contact;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return null;
	}

	public boolean checkContactNameExists(String contactName, String contactBookName) {
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
			while ((line = br.readLine()) != null) {
				String[] a = line.split(":");
				if (a[0].equals(contactName))
					return true;
			}
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}

			}
		}
	}

	public List<String> getAllContacts(String contactBookName) {
		System.out.println("get all contacts");
		BufferedReader br = null;
		List<String> result = new ArrayList<>();
		try {
			String line;
			br = new BufferedReader(new FileReader(contactBookName + ".tocall"));

			while ((line = br.readLine()) != null) {
				String[] a = line.split(":");
				result.add(a[0]);
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public String addContact(ContactBean contact, String contactBookName) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(contactBookName + ".tocall", true));
			bw.write(contact.getContactName() + ":" + contact.getTags() + ":" + contact.getAddress() + ":"
					+ contact.getPetName() + ":" + contact.getDob() + ":" + contact.getEmail() + ":"
					+ contact.getPhoneNo());
			bw.newLine();
			return Constants.SUCCESS;

		} catch (IOException e) {
			e.printStackTrace();
			return "something bad happened" + e.getMessage();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {

					e.printStackTrace();
					return "error occurs" + e.getMessage();
				}
			}
		}
	}
	

	public static Map findOccuranceSpecific(String word, List<String> l) {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		int count=0;
		for(String k:l)
		{if(k.contains(word)) {
			
		
			count=findOccurance(k, word);
			map.put(k, count);
		}}
		return map;
	}

	public  static List<String> getOneAttribute(String contactBookName, String key) {
		BufferedReader br = null;
		List<String> list = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] a = line.split(":");
				if (key.equals(Constants.PETNAME)) {
					list.add(a[3]);
				}	if (key.equals(Constants.TAG)) {
					list.add(a[1]);
				}if (key.equals(Constants.ADDRESS)) {
					list.add(a[2]);
				}
				if(key.equals(Constants.EMAIL))
				{
					List<String> l=ContactUtil.convertToList(a[5].substring(1, a[5].length() - 1));
					for(String j:l)
						list.add(j);
				}if(key.equals(Constants.PHONENO))
				{
					List<String> l=ContactUtil.convertToList(a[6].substring(1, a[6].length() - 1));
					for(String j:l)
						list.add(j);
				}

			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}
		return list;
	}
	public List<String> remindBirthDays(String contactBookName)
	{
		BufferedReader br=null;
		List<String> list=new ArrayList<String>();
		try {
			br=new BufferedReader(new FileReader(contactBookName+".tocalll"));
			String line;
			while((line=br.readLine())!=null)
			{
				String[] a=line.split(line);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date=LocalDate.parse(a[4], formatter);
				LocalDate now = LocalDate.now();
				if((date.getMonthValue()==now.getMonthValue())&&(date.getDayOfMonth()==now.getDayOfMonth()))
					list.add(a[0]);
			}
			return list;
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}
		return null;
	}
	
	public static int findOccurance(String line,String word)
	{int count = 0;
	int pos = 0;
	
		while ((pos = line.indexOf(word, pos)) != -1) {
			pos++;
			count++;
		}
return count;
	}

	public int findOccuranceOverall(String word, String contactBookName) {
		BufferedReader br = null;
		int count=0;
		try {
			br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
			String line;
			while ((line = br.readLine()) != null) {
				count=count+findOccurance(line, word);
			}
			return count;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}
		return 0;
	}

	public List<String> loadContactBook() {
		List<String> list = new ArrayList<>();
		File file = new File(".");
		if (file.exists() && file.isDirectory()) {
			File[] files = file.listFiles();
			for (File g : files) {
				if (g.getName().endsWith(".tocall"))
					list.add(g.getName());

			}
		}
		return list;
	}

	public List<ContactBean> listContacts(String contactBookName) {
		ContactBean contact = null;
		List<ContactBean> list = new ArrayList<ContactBean>();
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
			while ((line = br.readLine()) != null) {
				String[] a = line.split(":");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				List<String> mail = new ArrayList<String>();
				List<String> phNo = new ArrayList<String>();
				String f = a[5];
				String g = a[6];

				mail = ContactUtil.convertToList(f.substring(1, f.length() - 1));
				phNo = ContactUtil.convertToList(g.substring(1, g.length() - 1));
				contact = new ContactBean(a[0], a[1], a[2], a[3], a[4], mail, phNo);
				list.add(contact);

			}

			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	}

	public String createContactBook(String contactBookName) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(contactBookName + ".tocall"));
			return Constants.SUCCESS;

		} catch (IOException e) {
			e.printStackTrace();
			return "something bad happened" + e.getMessage();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {

					e.printStackTrace();
					return "error occurs" + e.getMessage();
				}
			}
		}
	}
}
