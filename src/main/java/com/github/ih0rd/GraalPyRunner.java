package com.github.ih0rd;

import com.github.ih0rd.contracts.*;
import com.github.ih0rd.contracts.OptimizeService;
import com.github.ih0rd.helpers.PythonExecutor;

import java.util.List;

import static java.lang.IO.println;


public class GraalPyRunner {


    void main() {
        var pythonExecutor = new PythonExecutor();

        var helloResult = pythonExecutor.evaluate("hello", Hello.class, "GraalDemo");
        println("helloResult = " + helloResult);

        var numResult = pythonExecutor.evaluate("num", Hello.class);
        println("numResult = " + numResult);

        var sumResult = pythonExecutor.evaluate("sum", Hello.class, 3,7);
        println("sumResult = " + sumResult);

        var aInput = List.of(List.of(1, 2), List.of(4, 0), List.of(0, 4));
        var bInput = List.of(8, 16, 12);
        var cInput = List.of(3, 2);
        var prob = "max";
        var enableMsg = true;
        var latex = true;
        var simplexArgs = new Object[]{aInput, bInput, cInput, prob, null, enableMsg, latex};

        var runSimplexResult = pythonExecutor.evaluate("run_simplex", OptimizeService.class, simplexArgs);
        println("runSimplexResult = " + runSimplexResult);

        pythonExecutor.closeContext();

    }
}