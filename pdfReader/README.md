# PDF Reader
## Description
A pdf file reader build with Apache PDFBox
PDFBox Verison: 2.0.27
Environment: IntelliJ IDEA
Funtions including:
- Create pdf
- Load existing pdf
- Edit pdf
- ...
## Apache PDFBox Tutorial
### Getting Started
#### Maven
To use the latest release you'll need to add the following dependency:
```xml
<dependency>
  <groupId>org.apache.pdfbox</groupId>
  <artifactId>pdfbox</artifactId>
  <version>2.0.27</version>
</dependency>
```
#### PDFBox and Java 8
Important notice when using PDFBox with Java 8 before 1.8.0_191 or Java 9 before 9.0.4

Due to the change of the java color management module towards "LittleCMS", users can experience slow performance in color operations. A solution is to disable LittleCMS in favor of the old KCMS (Kodak Color Management System) by:

- Starting with -Dsun.java2d.cmm=sun.java2d.cmm.kcms.KcmsServiceProvider or
- Calling System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider")
Sources: https://bugs.openjdk.java.net/browse/JDK-8041125

#### Rendering Performance
Since PDFBox 2.0.4

PDFBox 2.0.4 introduced a new command line setting
```console
-Dorg.apache.pdfbox.rendering.UsePureJavaCMYKConversion=true
```
which may improve the performance of rendering PDFs on some systems especially if there are a lot of images on a page.
