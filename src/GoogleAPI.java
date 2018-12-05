
import java.util.ArrayList;

public class GoogleAPI {
    public String getLineChart(String title, ArrayList<ChartElement> list, int width, int height) {
        String htmlString = 
        "  <html>\n" +
        "  <head>\n" +
        "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
        "    <script type=\"text/javascript\">\n" +
        "      google.charts.load('current', {'packages':['line']});\n" +
        "      google.charts.setOnLoadCallback(drawChart);\n" +
        "    function drawChart() {\n" +
        "      var data = new google.visualization.DataTable();\n" +
        "      data.addColumn('number', 'Day');\n" ;
        htmlString += "data.addColumn('number', '" + title + "');\n";
        //"      data.addColumn('number', 'Guardians of the Galaxy');\n";
        //"      data.addColumn('number', 'The Avengers');\n" +
        //"      data.addColumn('number', 'Transformers: Age of Extinction');\n" +
        htmlString +="      data.addRows([\n";
        //"        [10, 12.8, 30.9, 11.6],\n" +
        //"        [11,  5.3,  7.9,  4.7],\n" +
        //"        [12,  6.6,  8.4,  5.2],\n" +
        //"        [13,  4.8,  6.3,  3.6],\n" +
        //"        [14,  4.2,  6.2,  3.4]";
        htmlString += "[1,  15],\n" + 
                "[2,  20],\n" + 
                "[3,  30],\n" + 
                "[4,  16]\n" ;
        /*for(int i = 0; i < list.size(); i++) {
                    htmlString += "[" + i + "', '" + list.get(i).getValue() + "]\n";
                }*/
        htmlString +="      ]);\n" +
        "      var options = {\n" +
        "        chart: {\n" +
        "          title: '" + title + "',\n" +
        //"          subtitle: 'in millions of dollars (USD)'\n" +
        "        },\n" +
        "        width: 900,\n" +
        "        height: 500\n" +
        "      };\n" +
        "      var chart = new google.charts.Line(document.getElementById('linechart_material'));\n" +
        "      chart.draw(data, google.charts.Line.convertOptions(options));\n" +
        "    }\n" +
        "    </script>\n" +
        "  </head>\n" +
        "  <body>\n" +
        "    <div id=\"linechart_material\" style=\"width: 900px; height: 500px\"></div>\n" +
        "  </body>\n" +
        "</html>";
        return htmlString;
    }
}
