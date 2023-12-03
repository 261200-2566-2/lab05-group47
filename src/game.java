public class game {
    String playername;
    double damage;
    double hp;
    double shield;
    double speed;
    int level;
    double baseHp;
    double basedamage;
    double shieldbase;
    double speedbase;
    double swordweight;
    double shieldweight;
    String jobname;


//    job fromjob = new job();  //object ของ job = fromjob



    public game(double xHp,double yDamage,double zShield,double hSpeed){
       baseHp = xHp;
        basedamage = yDamage;
        shieldbase = zShield;
        speedbase = hSpeed;
        setHp();
        setSpeed();
        setDamage();
        setShield();
    }
    public void display() {
        System.out.println("------------------------");
        System.out.println("Class : "+ jobname); //เรียกจาก object fromjob
        System.out.println("Player name : " + playername);
        System.out.println("Level : " + level);
        System.out.println("HP : " + hp);
        System.out.println("Speed : " + speed);
        System.out.println("Damage : " + damage);
        System.out.println("Shield : " + shield);
        System.out.println("------------------------");
    }
//    โค้ดตรงส่วนนี้มีไว้แสดงสเตตัสของตัวละคร
//    public void generatePlayer(String playername) {
//
//        this.level = 120;
//        this.playername = playername;
//        setHp();
//        setSpeed();
//        setDamage();
//        setShield();
//
//    }
    //สร้างตัวละครและชื่อและตั้งค่าสเตตัสเริ่มต้น


//    public void base(){
//        damage = 2.0;
//        shield = 10.0;
//        speed = 100;
//        setHp();
//        setMana();
//        setSpeed();
//    }
    //สเตตัสเริ่มต้นของตัวละคร
    public void levelup(){
        level++;
        setHp();
        setSpeed();
        setDamage();
        setShield();
    }
    //เวลาเลเวลอัพจะมีการอัพเดทสเตตัสต่างๆที่กำหนดไว้ให้มค่าเพิ่มขึ้น

    public boolean UseSword(boolean x){
        if(x){
            swordweight=basedamage*(0.1+0.04*level);
            setSpeed();

        }
        else if (!x){
            this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        }
        return  x;
    }
    //เอาไว้เช็คว่าตัวละครนี้ใช้อาวุธหรือไม่ ถ้าใช้อาวุธก็จะอัพเดทดาเมจตามเลเวล และน้ำหนักของวัตถุ
    //ถ้าไม่ใช้ก็จะใช้ดาเมจตาม basedamage

    public boolean UseShield(boolean x){
        if(x){
            shieldweight=shieldbase*(0.1+0.08*level);
            shield += 50;
            setSpeed();
        }
        else if (!x){
            this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        }
        return  x;
    }
    //เอาไว้เช็คว่าตัวละครนี้ใช้โล่หรือไม่ ถ้าใช้็จะอัพเดทค่าโล่ตามเลเวล และน้ำหนักของวัตถุ
    //ถ้าไม่ใช้ก็จะใช้ดาเมจตาม basedamage
    public void setHp() {
        this.hp = baseHp+(10*level);
    }
    public void setSpeed(){
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
    }
    public void setDamage(){
        this.damage = basedamage*(1+(0.1*level));
    }
    public void setShield(){
        this.shield = shieldbase*(1+(0.05*level));
    }

    public boolean Hermes_Boots(boolean boots){
        if (boots) {
            this.speedbase = speedbase + 500;
            setSpeed();
        }
        else if(!boots) {
            this.speedbase = speedbase;
        }
        return  boots;
    }


    public boolean Atk_Ring(boolean ring){
        if (ring) {
            this.basedamage = basedamage + 100;
            setDamage();
        }
        else if(!ring) {
            this.basedamage = basedamage;
        }
        return  ring;
    }

    public void attack(game opponent) {

        double DmgAttacker = 0;

        if(damage >= opponent.shield ){
            DmgAttacker = damage - opponent.shield;
            if(opponent.shield > 0){
                opponent.shield = DmgAttacker - opponent.shield;
            }else if(opponent.shield < 0){
                opponent.shield = 0;
            }

            opponent.hp = opponent.hp - DmgAttacker ;
        }
        else if(damage < opponent.shield){
            DmgAttacker = opponent.shield - damage;
            if(opponent.shield > 0){
                opponent.shield = opponent.shield - DmgAttacker;
            }else if(opponent.shield < 0){
                opponent.shield = 0;
            }

        }

        if(opponent.shield < 0){
            opponent.shield = 0;
        }

        if(opponent.hp > 0) {
            System.out.println("------------------------");
            System.out.println(this.playername + " attacks " + opponent.playername + " for " + DmgAttacker + " damage.");
            System.out.println(opponent.playername + "'s Current Shield: " + opponent.shield);
            System.out.println(opponent.playername + "'s Current HP: " + opponent.hp);
            System.out.println("------------------------");
        }
        else if(opponent.hp < 0) {
            opponent.hp = 0;
            System.out.println("==============");
            System.out.println(opponent.playername + "'s Current HP: " + opponent.hp);
            System.out.println(this.playername + " kill " + opponent.playername );
            System.out.println("==============");
        }
    }
}
