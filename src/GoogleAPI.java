
import java.util.ArrayList;

public class GoogleAPI {
  
    public String getLineChart(String title, ArrayList<ChartElement> list) {
        int i = 0;
        String htmlString = 
                "  <html>\n" +
                "  <head>\n" +
                "    <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "    <script type=\"text/javascript\">\n" +
                "            google.charts.load('current', {'packages':['line', 'corechart','annotationchart']});\n" +
                "      google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "    function drawChart() {\n" +
                "\n" +
                "      var button1 = document.getElementById('MaterialChart');\n" +
                "      var button2 = document.getElementById('ClassicChart');\n" +
                "      var button3 = document.getElementById('AreaChart');\n" +
                "      var button4 = document.getElementById('AnnotationChart');\n" +
                "      var chartDiv = document.getElementById('chart_div');\n" +
                "\n" +
                "      var data = new google.visualization.DataTable();\n" +
                "      data.addColumn('date', 'Datetime');\n" +
                "      data.addColumn('number', \"Temperature\");\n" +
                "      data.addColumn('number', \"Humidity\");\n" +
                "\n" +
                "      data.addRows([\n";
                for(i = 0; i < list.size()-1; i++) {
                        htmlString += "[new Date(" + list.get(i).getName().substring(0,4) + ", " + list.get(i).getName().substring(5,7) + "-1, " + list.get(i).getName().substring(8,10) + ", "
                                                       + list.get(i).getName().substring(11,13) + ", "+ list.get(i).getName().substring(14,16) + ", 00), "                   
                                                       + list.get(i).getValue1() + ", "  
                                                       + list.get(i).getValue2() + "],\n";
                    }
                htmlString +=
                "      ]);\n" +
                "\n" +
                "      var materialOptions = {\n" +
                "        chart: {\n" +
                "          title: 'Temperatures and Humidity in Inside'\n" +
                "        },\n" +
                "        series: {\n" +
                "          // Gives each series an axis name that matches the Y-axis below.\n" +
                "          0: {axis: 'Temps'},\n" +
                "          1: {axis: 'Humis'}\n" +
                "        },\n" +
                "        axes: {\n" +
                "          // Adds labels to each axis; they don't have to match the axis names.\n" +
                "          y: {\n" +
                "            Temps: {label: 'Temps (Celsius)'},\n" +
                "            Humis: {label: 'Humis (Percent)'}\n" +
                "          }\n" +
                "        }\n" +
                "      };\n" +
                "\n" +
                "      var classicOptions = {\n" +
                "        title: 'Temperatures and Humidity in Inside',\n" +
                "        series: {\n" +
                "          0: {targetAxisIndex: 0},\n" +
                "          1: {targetAxisIndex: 1}\n" +
                "        },\n" +
                "        vAxes: {\n" +
                "          // Adds titles to each axis.\n" +
                "          0: {title: 'Temps (Celsius)'},\n" +
                "          1: {title: 'Humis (Percent)'}\n" +
                "        },\n" +
                "      };\n" +
                "\n" +
                "      var areaOptions = {\n" +
                "        title: 'Temperatures and Humidity in Inside',\n" +
                "        series: {\n" +
                "          0: {targetAxisIndex: 0},\n" +
                "          1: {targetAxisIndex: 1}\n" +
                "        },\n" +
                "        vAxes: {\n" +
                "          // Adds titles to each axis.\n" +
                "          0: {title: 'Temps (Celsius)'},\n" +
                "          1: {title: 'Humis (Percent)'}\n" +
                "        },\n" +
                "      };\n" +
                "\n" +
                "      var annotationOptions = {\n" +
                "        title: 'Temperatures and Humidity in Inside',\n" +
                "        displayAnnotations: false" +
                "      };\n" +
                "\n" +
                "      function drawMaterialChart() {\n" +
                "        var materialChart = new google.charts.Line(chartDiv);\n" +
                "        materialChart.draw(data, materialOptions);\n" +
                "        button1.onclick = drawClassicChart;\n" +
                "        button2.onclick = drawMaterialChart;\n" +
                "        button3.onclick = drawAreaChart;\n" +
                "        button4.onclick = drawAnnotationChart;\n" +
                "      }\n" +
                "\n" +
                "      function drawClassicChart() {\n" +
                "        var classicChart = new google.visualization.LineChart(chartDiv);\n" +
                "        classicChart.draw(data, classicOptions);\n" +
                "      }\n" +
                "\n" +
                "      function drawAreaChart() {\n" +
                "        var areaChart = new google.visualization.AreaChart(chartDiv);\n" +
                "        areaChart.draw(data, areaOptions);\n" +
                "      }\n" +
                "\n" +
                "      function drawAnnotationChart() {\n" +
                "        var annotationChart = new google.visualization.AnnotationChart(chartDiv);\n" +
                "        annotationChart.draw(data, annotationOptions);\n" +
                "      }\n" +
                "\n" +
                "      drawMaterialChart();\n" +
                "\n" +
                "    }\n" +
                "    </script>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <button id=\"ClassicChart\" style=\"width:200px;height:30px\">Classic Chart</button>\n" +
                "    <button id=\"MaterialChart\" style=\"width:200px;height:30px\">Material Chart</button>\n" +
                "    <button id=\"AreaChart\" style=\"width:200px;height:30px\">Area Chart</button>\n" +
                "    <button id=\"AnnotationChart\" style=\"width:200px;height:30px\">Annotation Chart</button>\n" +
                "    <br><br>\n" +
                "    <center>\n" +
                "      <div id=\"chart_div\" style=\"width: 100%; height: 89%\"></div>\n" +
                "    </center>\n" +
                "   \n" +
                "  </body>\n" +
                "</html>";
        return htmlString;
    }
}
