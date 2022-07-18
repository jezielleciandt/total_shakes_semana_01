public class Name {
    //variáveis que falam por si só
    //A
    public Date modifiedDate;
    public List<Testcase> findAllTestcasesByUser(Name.User user){};
    //B
//    public Date d; // modified date
//    public List<Testcase> find(Name.User user){}; //find all Testcases by User

    //Declarações corretas
    //A
    public List<Account> AccountList;
    //B
//    public Account[] AccountList;

    // Sem Prefixos
    //A
//    public void deleteUser(Name.User pUser){};
    //B
    public void deleteUser(Name.User user){};

    // Evite mapa mental
    //A
//    public URL r;
    //B
    public URL url;

    // Classe possui nomes próprios, funções devem ter verbos
    //A
    public class TableRepresent {};
    public void saveCar(){};
    //B
//    public class TableRepresenter{};
//    public void car(){};

    // Uma palavra por conceito
    //A
    public saveUser(){}; saveAccount(){}; saveContract(){};
    //B
//    public saveUser(){}; createAccount(){}; generateContract(){};


    //Use constants, enums instead of magic numbers, abbreviations
    //A
//    public int daysInYear = 360;
//    public int hoursInWeek = 168;
    //B
    public final int DAYS_IN_YEAR = 360;
    public final int HOURS_IN_WEEK = 168;
}

