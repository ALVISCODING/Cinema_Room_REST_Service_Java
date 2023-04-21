class Employee {

    // write fields
    String name;
    String email;
    int experience;

    // write constructor

    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    // write getters


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
}

class Developer extends Employee {

    // write fields
    String mainLanguage;
    String skills;


    // write constructor

    public Developer(String name, String email, int experience, String mainLanguage, String skills) {
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }


    // write getters

    public String getMainLanguage() {
        return mainLanguage;
    }

    public String getSkills() {
        return skills;
    }
}

class DataAnalyst extends Employee {

    // write fields
    Boolean phd;
    String methods;

    // write constructor

    public DataAnalyst(String name, String email, int experience, Boolean phd, String methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods;
    }


    // write getters


    public Boolean getPhd() {
        return phd;
    }

    public String getMethods() {
        return methods;
    }
}
