package robi;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        String fileName = "jackie.txt";
        File jackieTxt = new File(fileName);
        Scanner jackieScanner = new Scanner(jackieTxt);
        ArrayList<Jackie> jackieList = new ArrayList<>();
        jackieScanner.nextLine();
        while (jackieScanner.hasNextLine()) {
            String line = jackieScanner.nextLine();
            jackieList.add(new Jackie(line));
        }

        System.out.println("Jackie Stewart");
        System.out.println("3.feladat: " + jackieList.size());
        Optional<Jackie> moreRaces = jackieList.stream().max((j1, j2) -> Integer.compare(j1.getRaces(), j2.getRaces()));
        System.out.println("4.feladat: " + moreRaces.get().getYear());

        HashMap<Integer, Integer> yearDec = new HashMap<>();
        for (Jackie j : jackieList) {
            Integer yearD = j.getYear() / 10;
            if (yearDec.containsKey(yearD)) yearDec.put(yearD, yearDec.get(yearD) + 1);
            else yearDec.put(yearD, 1);
        }
        System.out.println("5.feladat");
        for (Integer key : yearDec.keySet()) {
            System.out.println("   " + ((key % 10) * 10) + "-as évek: " + yearDec.get(key) + " megnyert verseny.");
        }
        System.out.println("6.feladat: jackie.html");
        StringBuilder html = new StringBuilder();
        String htmlName = "table.html";
        String htmlLoad = Files.readString(Path.of(htmlName));
        html.append(htmlLoad);
        for (Jackie j : jackieList) {
            String year = Integer.toString(j.getYear());
            String races = Integer.toString(j.getRaces());
            String wins = Integer.toString(j.getWins());
            html.append("<tr>");
            html.append("<td>");
            html.append(year);
            html.append("</td>");
            html.append("<td>");
            html.append(races);
            html.append("</td>");
            html.append("<td>");
            html.append(wins);
            html.append("</td>");
            html.append("</tr>\n");
        }
        html.append("</tbody>\n");
        html.append("</table>\n");
        html.append("</body>\n");
        html.append("</html>\n");

        String wName = "jackie.html";
        Files.writeString( Path.of( wName), html.toString());
        System.out.println( html.toString());
    }
}
