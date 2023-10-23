package yachts;
import java.lang.StringBuffer;

public class Yacht{
    private String nume;
    private int lungime;
    private double pret;
    public static final int nrpropietari = 1;
    public Yacht(String nume,int lungime,double pret)
    {
       this.nume = nume;
       this.lungime = lungime;
       this.pret = pret;
    }
    public Yacht(double pret,String nume)
    {
        this.nume = nume;
        this.pret = pret;
    }
    public void setNume(String nume)
    {
        this.nume = nume;
    }
    public String getNume()
    {
        return nume;
    }
    public void setLungime(int lungime)
    {
        this.lungime = lungime;
    }
    public int getLungime()
    {
        return lungime;
    }
    public void setPret(double pret)
    {
        this.pret = pret;
    }
    public double getPret()
    {
        return pret;
    }
    public int getNrPropietari()
    {
        return nrpropietari;
    }
    public String verificareLux()
    {
        if(pret<1000000)
          return "Yacht-ul este unul normal!";
        else
          return "Yact-ul este de lux!";
    }
    @Override
    public String toString()
    {
      StringBuffer sb = new StringBuffer();
      sb.append("Yacht-ul se numeste ").append(nume).append(", ");
      sb.append("are o lungime de ").append(lungime).append(" metri, ");
      sb.append("si costa ").append(pret).append(" euro!");
      return sb.toString();
    }
}