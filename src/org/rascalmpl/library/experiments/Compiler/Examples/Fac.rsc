module experiments::Compiler::Examples::Fac

import IO;
int   fac(int n) = (n <= 1) ? 1 : n * fac(n-1);
 
//int main(str n = "24"){
//    return fac(toInt(n));
//} 

int main() { n = fac(10); println(n); return n; }


test bool tfac() = fac(24) == 620448401733239439360000;