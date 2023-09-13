const report = require("multiple-cucumber-html-reporter");

report.generate({
  jsonDir: "./ReporteCucumber/",
  reportPath: "./ReporteCucumber/",
  openReportInBrowser: true,
  disableLog: false,
  	pageTitle: "Reportes DIAN",
  	reportName: "DIAN",
  	displayDuration: true,

  metadata: {
    browser: {
      name: "chrome",
      version: "111",
    },
    device: "Local test machine",
    platform: {
      name: "ubuntu",
      version: "16.04",
      enviroments: "QA"
    },
  },
  customData: {
    title: 'Información de la ejecución Reporte DIAN',
    data: [
      { label: "Project", value: "DIAN" },
      { label: "Release", value: "1.2.3" },
      { label: "Cycle", value: "1" },
      { label: "Execution Start Time", value: date = new Date().toUTCString() }
    ],
  },
});