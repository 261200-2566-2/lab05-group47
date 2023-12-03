public class Main {
    public static void main(String[] args) {

        Build A = new Build("Tank","Tiger");
        Build B = new Build("Assassin","Fitto");
        Build C = new Build("Ranger","Korn");

        A.Hermes_Boots(true);
        A.Atk_Ring(true);
        A.UseSword(false);
        A.UseShield(false);

        B.Hermes_Boots(true);
        B.Atk_Ring(false);
        B.UseSword(true);
        B.UseShield(true);

        C.Hermes_Boots(true);
        C.Atk_Ring(true);
        C.UseSword(true);
        C.UseShield(true);



        B.display();
        C.display();

        B.attack(C);
        B.attack(C);
        B.attack(C);
        B.attack(C);
        B.attack(C);
        B.attack(C);
        B.attack(C);
        B.attack(C);
        B.attack(C);
        B.attack(C);

        C.display();


//อันนี้ลองเทสว่าเวลาเลเวลอัพค่าสเตตัสจะอัพขึ้นตามเลเวลหรือไม่



    }
}