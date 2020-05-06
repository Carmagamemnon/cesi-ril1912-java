public class BonjourPersonnalise {
  public static void main(String[] arg){
    String name = arg.length > 0 ? arg[0] : "inconnu";
    System.out.println("Coucou ".concat(name));
  }
}