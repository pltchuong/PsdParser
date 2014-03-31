Dim jsx
Dim input
Dim output

Set photoshop = CreateObject("Photoshop.Application")
Set fso       = CreateObject("Scripting.FileSystemObject")

jsx    = fso.BuildPath(fso.GetAbsolutePathName("."), "src\com\psdparser\ext\export.jsx")
input  = Wscript.Arguments(0)
output =  Wscript.Arguments(1)

Call photoshop.DoJavaScriptFile(jsx, Array(input, output))