#! /bin/bash


if [ $# -ne 2 ]; then
   echo "Usage: $0 premier_entier second_entier"
    exit 1
fi

# TODO: Vérifier que $1 est un entier positif
if ! [[ "$1" =~ ^[0-9]+$ ]]; then
    echo "$1 n'est pas un entier"
    exit 2
fi
# TODO: Vérifier que $2 est un entier positif
if ! [[ "$2" =~ ^[0-9]+$ ]]; then
    echo "$2 n'est pas un entier"
    exit 3
fi

if [ $1 -gt $2 ]; then
    echo "Le deuxième paramètre doit être supérieur au premier paramètre !!!!"
    exit 1
fi

for i in $(seq $1 $2); do
    javac Syracuse.java
    java Syracuse $i
    echo "$i `tail -n3 $i.dat | head -n1 |cut -f2 -d '='`" >> altimax.dat
    echo "$i `tail -n2 $i.dat | head -n1 |cut -f2 -d '='`" >> dureevol.dat
    echo "$i `tail -n1 $i.dat | cut -f2 -d '='`" >> dureealtitude.dat
    rm $i.dat
done