import java.io.*;

public class Syracuse
{
    public static void main(String [] args)
    {
        int n = Integer.parseInt(args[0]);
        try
        {
            FileWriter fw = new FileWriter(args[1]);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("n Un");
            bw.newLine();
            Integer i = 0;
            bw.write(i + " " + n);
            bw.newLine();
            Integer initialvalue = n;
            Integer dureealtitude = 0;
            Integer max = n;
            i++;
            Integer verif = 1;
            while (n != 1){
                n=(n%2 == 0) ? n / 2 : n * 3 + 1; 
                if(n > max){
                    max = n;
                }
                if (n > initialvalue && verif == 1){
                    dureealtitude ++;
                }
                else {
                    verif = 0;
                }
                bw.write(i + " " + n);
                bw.newLine();
                i ++;
            }
            bw.write("altimax="+max);
            bw.newLine();
            bw.write("dureevol="+i);
            bw.newLine();
            bw.write("dureealtitude="+dureealtitude);
            bw.newLine();
            bw.close();
        }catch (Exception e){
            System.out.println("ERREUR");
        }

    }
}