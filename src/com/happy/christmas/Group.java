package com.happy.christmas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Group {
	private List<Person> groupMemberList;
	
	public Group(List<Person> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}

	public List<Person> getGroupMemberList() {
		return groupMemberList;
	}
	
	public void setPersonBlackList(Person groupMember, final List<Person> blackList) {
		groupMember.setWhiteList(groupMemberList.stream().filter(p -> !blackList.contains(p)).collect(Collectors.toList()));
	}
	
	public void addPersonBlackList(Person groupMember, Person personToAddToblackList) {
		groupMember.getWhiteList().remove(personToAddToblackList);
	}

	public static void main(String[] args) {
		Person Steve = new Person("Steve", UUID.randomUUID());
		Person Mike = new Person("Mike", UUID.randomUUID());
		Person Eric = new Person("Eric", UUID.randomUUID());
		Person Chrissy = new Person("Chrissy", UUID.randomUUID());
		Person Michelle = new Person("Michelle", UUID.randomUUID());
		Person Mary = new Person("Mary", UUID.randomUUID());
		Person Joyce = new Person("Joyce", UUID.randomUUID());
		Person Neal = new Person("Neal", UUID.randomUUID());
		Person Karen = new Person("Karen", UUID.randomUUID());
		Person Dave = new Person("Dave", UUID.randomUUID());
		Person Katy = new Person("Katy", UUID.randomUUID());
		Person Derek = new Person("Derek", UUID.randomUUID());
		Person Zak = new Person("Zak", UUID.randomUUID());
		Person Kevin = new Person("Kevin", UUID.randomUUID());
		Person Carl = new Person("Carl", UUID.randomUUID());
		Person Kathy = new Person("Kathy", UUID.randomUUID());
		Person Caitlin = new Person("Caitlin", UUID.randomUUID());
		Person Dailey = new Person("Dailey", UUID.randomUUID());
		Person Kerry = new Person("Kerry", UUID.randomUUID());
		Person Gail = new Person("Gail", UUID.randomUUID());
		Person JohnH = new Person("JohnH", UUID.randomUUID());
		Person Lisa = new Person("Lisa", UUID.randomUUID());
		Person Samantha = new Person("Samantha", UUID.randomUUID());
		Person JohnK = new Person("JohnK", UUID.randomUUID());
		Person Greg = new Person("Greg", UUID.randomUUID());
		Person Jaime = new Person("Jaime", UUID.randomUUID());
		
		Group family = new Group(Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, 
				Neal, Karen, Dave, Katy, Derek, Zak, Kevin, Carl, Kathy, Caitlin, Kerry, Dailey, 
				Gail, JohnH, Lisa, Samantha, JohnK, Greg, Jaime));
		
		family.setPersonBlackList(Steve, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal, JohnK));
		family.setPersonBlackList(Mike, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal, Lisa));
		family.setPersonBlackList(Eric, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal));
		family.setPersonBlackList(Chrissy, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal, Greg));
		family.setPersonBlackList(Michelle, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal));
		family.setPersonBlackList(Joyce, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal, Caitlin));
		family.setPersonBlackList(Neal, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal, Carl));
		family.setPersonBlackList(Mary, Arrays.asList(Steve, Mike, Eric, Chrissy, Michelle, Mary, Joyce, Neal, JohnH));

		family.setPersonBlackList(Karen, Arrays.asList(Karen, Dailey));

		family.setPersonBlackList(Dave, Arrays.asList(Dave, Katy, Derek, Zak, Kevin, Kathy));
		family.setPersonBlackList(Katy, Arrays.asList(Dave, Katy, Derek, Zak, Kevin, Katy));
		family.setPersonBlackList(Derek, Arrays.asList(Dave, Katy, Derek, Zak, Kevin, Karen));
		family.setPersonBlackList(Zak, Arrays.asList(Dave, Katy, Derek, Zak, Kevin, Chrissy));
		family.setPersonBlackList(Kevin, Arrays.asList(Dave, Katy, Derek, Zak, Kevin, Gail));

		family.setPersonBlackList(Carl, Arrays.asList(Carl, Caitlin, Kerry, Kathy, Dailey, Samantha));
		family.setPersonBlackList(Caitlin, Arrays.asList(Carl, Caitlin, Kerry, Kathy, Dailey, Mike));
		family.setPersonBlackList(Kerry, Arrays.asList(Carl, Caitlin, Kerry, Kathy, Dailey, Katy));
		family.setPersonBlackList(Kathy, Arrays.asList(Carl, Caitlin, Kerry, Kathy, Dailey, Jaime));
		family.setPersonBlackList(Dailey, Arrays.asList(Carl, Caitlin, Kerry, Kathy, Dailey, Kevin));

		family.setPersonBlackList(Gail, Arrays.asList(Gail, Joyce));

		family.setPersonBlackList(JohnH, Arrays.asList(JohnH, Lisa, Samantha, Greg, Jaime, Zak));
		family.setPersonBlackList(Lisa, Arrays.asList(JohnH, Lisa, Samantha, Greg, Jaime, Dave));
		family.setPersonBlackList(Samantha, Arrays.asList(JohnH, Lisa, Samantha, Greg, Jaime, Mary));
		family.setPersonBlackList(JohnK, Arrays.asList(JohnH, Lisa, Samantha, Greg, Jaime, Neal));
		family.setPersonBlackList(Greg, Arrays.asList(JohnH, Lisa, Samantha, Greg, Jaime, Steve));
		family.setPersonBlackList(Jaime, Arrays.asList(JohnH, Lisa, Samantha, Greg, Jaime, Derek));
		
		int i=0;
		while (i < family.getGroupMemberList().size()) {
			Person person = family.getGroupMemberList().get(i);

			if (person.getWhitelistIndex() == -1) {
				Collections.shuffle(person.getWhiteList());
			}
			
			for (int j = person.getWhitelistIndex() + 1; j < person.getWhiteList().size(); j++) {
				Person personToSelect = person.getWhiteList().get(j);
				
				if (!personToSelect.isSelected()) {
					person.setPersonSelected(personToSelect);
					person.setWhitelistIndex(j);
					personToSelect.setSelected(true);
					break;
				}
			}
			
			if (person.getPersonSelected() != null) {
				i++;
			} else {
				person.setWhitelistIndex(0);
				i--;
				
				if (i >= 0) {
					person = family.getGroupMemberList().get(i);
					person.getPersonSelected().setSelected(false);
					person.setPersonSelected(null);
				} else {
					System.out.println("No combination is available :(.");
					System.exit(1);
				}
			}
		}
		
		for (Person groupMember : family.getGroupMemberList()) {
			System.out.println(groupMember.getName() + "\t\t" + groupMember.getPersonSelected().getName());
		}
	}
}