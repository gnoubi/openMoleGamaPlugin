
BUNDLES="$2/bundles/"
LIBS="$2/lib"

mkdir -p $BUNDLES
mkdir -p $LIBS

for f in `cat bundles.list`
do
  cp $1/$f $BUNDLES/
done

cd $LIBS

for f in `ls ../bundles`
do
  ln -s ../bundles/$f
done

jar -xvf msi.gama.ext_1.0.0.jar
rm -rf msi.gama.ext_1.0.0.jar META-INF

cd -

mv $BUNDLES/org.apache.commons.logging_*.jar $LIBS
mv $BUNDLES/org.apache.log4j_*.jar $LIBS
