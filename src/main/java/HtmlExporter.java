public class HtmlExporter implements Exporter{

    // REQUIRES employeesSummary != null
    // ̶M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // EFFECTS returns a string that contains the body of a html document with the report info.
    @Override
    public String export(EmployeesSummary employeesSummary) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>ACME Report</title></head>";
        result += "<body>";
        result += "<h1> Employees At Same Time Frame Report </h1>";
        result += "<ul>";
        for (String line: employeesSummary.getEmployeesAtSameTimePeriod()){
            result += "<li><strong>-</strong>: " + line + "</li>";
        }
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
