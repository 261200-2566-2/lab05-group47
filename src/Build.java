public class Build extends game {
    public Build(String jobname,String playername){
        super(100,10,10,100);
        this.level = 0;
        this.jobname = jobname;
        this.playername = playername;
        switch (jobname) {
            case "Tank" -> setTank();
            case "Assassin" -> setAssassin();
            case "Ranger" -> setRanger();
        }
    }

    public void setTank(){
        this.baseHp = 500;
        this.hp = baseHp+(10*level);
        this.basedamage = 20;
        this.damage = basedamage*(1+(0.1*level));
        this.speedbase = 300;
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        this.shieldbase = 50;
        this.shield = shieldbase*(1+(0.05*level));
    }

    public void setAssassin(){
        this.baseHp = 350;
        this.hp = baseHp+(10*level);
        this.basedamage = 35;
        this.damage = basedamage*(1+(0.1*level));
        this.speedbase = 500;
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        this.shieldbase = 30;
        this.shield = shieldbase*(1+(0.05*level));
    }

    public void setRanger(){
        this.baseHp = 250;
        this.hp = baseHp+(10*level);
        this.basedamage = 50;
        this.damage = basedamage*(1+(0.1*level));
        this.speedbase = 450;
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        this.shieldbase = 20;
        this.shield = shieldbase*(1+(0.05*level));
    }
}
