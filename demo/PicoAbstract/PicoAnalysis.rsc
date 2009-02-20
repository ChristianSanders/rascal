module PicoAnalysis

import PicoAbstractSyntax;

public data ProgramPoint = pp(EXP exp, int label) | pp(STATEMENT stat, int label);

alias CFG = rel[ProgramPoint, ProgramPoint];

alias Entry = set[ProgramPoint];

alias Exit = set[ProgramPoint];

public data BLOCK = block(Entry entry, CFG graph, Exit exit);