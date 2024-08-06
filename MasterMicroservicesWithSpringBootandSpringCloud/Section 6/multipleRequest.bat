@echo off
setlocal enabledelayedexpansion

set count=0
set max_requests=50

:loop
if !count! lss %max_requests% (
    curl -X GET "http://localhost:8000/sample-api"
    set /a count+=1
    goto loop
)

pause
