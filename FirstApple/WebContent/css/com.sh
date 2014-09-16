#!/bin/bash
pathC=$SRCDIR/trans
pathSo=$HOME/lib
rm -f $SRCDIR/tool/compare/verso_temp.txt
cd $pathSo
ls -l lib*.so
for i in `ls lib*.so`;do  
    showver $i 2>> $SRCDIR/tool/compare/verso_temp.txt 
done
echo 'SOSTACK' > $SRCDIR/tool/compare/ver_so.ini
#cat $SRCDIR/tool/compare/ver_temp.txt | grep '【' |sed 's/】/ /g' | sed 's/【/ /g' | sed 's/\.so/ /g' |awk '{print $2 "=" $4}' >> $SRCDIR/tool/compare/ver_so.ini
cat $SRCDIR/tool/compare/verso_temp.txt | grep "【" |sed "s/】/ /g" | sed "s/【/ /g" | sed "s/\.so/ /g" |awk '{print $2 "=" $4}' >> $SRCDIR/tool/compare/ver_so.ini