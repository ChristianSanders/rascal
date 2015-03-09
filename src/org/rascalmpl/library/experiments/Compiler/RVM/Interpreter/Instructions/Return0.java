package org.rascalmpl.library.experiments.Compiler.RVM.Interpreter.Instructions;

import org.rascalmpl.library.experiments.Compiler.RVM.Interpreter.CodeBlock;
import org.rascalmpl.library.experiments.Compiler.RVM.ToJVM.BytecodeGenerator;

public class Return0 extends Instruction {
	
	public Return0(CodeBlock ins) {
		super(ins, Opcode.RETURN0);
	}
	public void generate(BytecodeGenerator codeEmittor, boolean dcode){
		codeEmittor.emitInlineReturn(0,dcode);
		codeblock.addCode0(opcode.getOpcode());
	}
}
