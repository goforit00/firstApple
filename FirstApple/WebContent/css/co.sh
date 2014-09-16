#!/bin/bash
fgrep 'SYSTEM_VER' $SRCDIR/trans/*/* | fgrep 'define' | sed 's/#/ /g' | awk '{print $1 "=" $4}' > $SRCDIR/tool/compare/verc_temp.txt
#cat $SRCDIR/tool/compare/ver_temp.txt | grep 'lib' | sed 's/lib/  lib/g' > $SRCDIR/tool/compare/ver_c.txt
cat $SRCDIR/tool/compare/ver_temp.txt | grep '[^_]lib' | sed 's/lib/  lib/g' | awk '{print $2}' | sed 's/\// /g' | sed 's/\"/ /g' | sed 's/:=//g' | awk '{print $1 "|" $2 "|" $3}' > $SRCDIR/tool/compare/ver_c.txt
cat $SRCDIR/tool/compare/ver_temp.txt | grep '[^_]lib' | sed 's/lib/  lib/g' | awk '{print $2}' | sed 's/\// /g' | sed 's/\"/ /g' | sed 's/:=//g' | awk '{print $1 "|" $2 "|" $3}' > $SRCDIR/tool/compare/ver_c.txt