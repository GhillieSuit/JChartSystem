
import java.util.ArrayList;

public class GoogleAPI {
    public String getLineChart(String title, ArrayList<ChartElement> list, int width, int height) {
        int i = 0;
        String htmlString = 
        "  <html>\n" +
        "  <head>\n" +
        "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
        "    <script type=\"text/javascript\">\n" +
        "      google.charts.load('current', {'packages':['line']});\n" +
        "      google.charts.setOnLoadCallback(drawChart);\n" +
        "    function drawChart() {\n" +
        "      var data = new google.visualization.DataTable();\n" +
        "      data.addColumn('number', 'Datetime');\n" +
        "      data.addColumn('number', 'tem');\n"+
        "      data.addColumn('number', 'hum');\n"+
        "      data.addRows([\n";
        for(i = 0; i < list.size()-1; i++) {
                    htmlString += "[" + i + ", " + list.get(i).getValue1() + ", " + list.get(i).getValue2() + "],\n";
                }
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
