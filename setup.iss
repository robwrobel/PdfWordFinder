; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{6DCA69B7-339B-4626-A66E-0A9FD9E809F8}
AppName=PDFWordFinder
AppVersion=1.1
AppPublisher=Robert Wr?bel
DefaultDirName={pf}\PDFWordFinder
DisableDirPage=yes
DefaultGroupName=PDFWordFinder
DisableProgramGroupPage=yes
OutputDir=C:\Users\Robert\workspace\PDFWordFinder\install
OutputBaseFilename=setup
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "c:\Users\Robert\workspace\PDFWordFinder\PDFWordFinder.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\pdfbox-app-1.8.2.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\swt.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\poi-3.9-20121203.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\poi-scratchpad-3.9-20121203.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\commons-io-2.4.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\dom4j-1.6.1.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\xmlbeans-2.3.0.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "c:\Users\Robert\workspace\PDFWordFinder\poi-ooxml-3.9-20121203.jar"; DestDir: "{app}"; Flags: ignoreversion

Source: "c:\Users\Robert\workspace\PDFWordFinder\jre-6u45-windows-i586.exe"; DestDir: "{app}"; Flags: ignoreversion
[Icons]
Name: "{group}\PDFWordFinder";Filename: "c:\Program Files\Java\jre6\bin\javaw.exe";Parameters:"-cp dom4j-1.6.1.jar;xmlbeans-2.3.0.jar;poi-ooxml-3.9-20121203.jar;pdfbox-app-1.8.2.jar;PDFWordFinder.jar;swt.jar;poi-3.9-20121203.jar;poi-scratchpad-3.9-20121203.jar;commons-io-2.4.jar;poi-ooxml-schemas-3.9-20121203.jar PDFWordFinder";WorkingDir: "{app}"

Name: "{commondesktop}\PDFWordFinder"; Filename: "c:\Program Files\Java\jre6\bin\javaw.exe";Parameters:"-cp dom4j-1.6.1.jar;xmlbeans-2.3.0.jar;poi-ooxml-3.9-20121203.jar;pdfbox-app-1.8.2.jar;PDFWordFinder.jar;swt.jar;poi-3.9-20121203.jar;poi-scratchpad-3.9-20121203.jar;commons-io-2.4.jar;poi-ooxml-schemas-3.9-20121203.jar PDFWordFinder";WorkingDir: "{app}"

[Run]
Filename: "{app}\jre-6u45-windows-i586.exe"; Parameters: "/s "; Description: "Installing java";





