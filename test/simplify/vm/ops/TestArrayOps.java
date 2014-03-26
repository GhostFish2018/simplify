package simplify.vm.ops;

import java.util.logging.Logger;

import org.junit.Test;

import simplify.Main;
import simplify.vm.MethodContext;
import simplify.vm.VMTester;
import simplify.vm.types.UninitializedInstance;
import util.SparseArray;

public class TestArrayOps {

    private static final Logger log = Logger.getLogger(Main.class.getSimpleName());

    private static final String CLASS_NAME = "Larray_test;";

    @Test
    public void TestArrayPut() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new int[] { 4 });

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestArrayPut()V", registerState);
    }

    @Test
    public void TestArrayPutWide() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new long[] { 5L });

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestArrayPutWide()V", registerState);
    }

    @Test
    public void TestNewArrayLocal() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        UninitializedInstance[] instances = new UninitializedInstance[1];
        instances[0] = new UninitializedInstance(CLASS_NAME);
        registerState.put(0, instances);

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestNewArrayLocal()V", registerState);
    }

    @Test
    public void TestNewArrayPrimitive() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new int[1]);

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestNewArrayPrimitive()V", registerState);
    }

    @Test
    public void TestArrayGetUninitializedPrimitive() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, (new int[1])[0]);

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestArrayGetUninitializedPrimitive()V", registerState);
    }

    @Test
    public void TestNewArrayMultiDimensionalPrimitive() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new int[2][][]);

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestNewArrayMultiDimensionalPrimitive()V", registerState);
    }

    @Test
    public void TestNewArrayMultiDimensionalLocal() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        UninitializedInstance[][][] expected = new UninitializedInstance[2][][];
        registerState.put(0, expected);

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestNewArrayMultiDimensionalLocal()V", registerState);
    }

    @Test
    public void TestFilledNewArrayPrimitive() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(MethodContext.ResultRegister, new int[1][2][3][4][5]);

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestFilledNewArrayPrimitive()V", registerState);
    }

    @Test
    public void TestFilledNewArrayLocal() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        UninitializedInstance[][][] expected = new UninitializedInstance[1][2][3];
        for (UninitializedInstance[][] inner1 : expected) {
            for (UninitializedInstance[] inner2 : inner1) {
                for (int i = 0; i < inner2.length; i++) {
                    inner2[i] = new UninitializedInstance(CLASS_NAME);
                }
            }
        }

        registerState.put(MethodContext.ResultRegister, expected);

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestFilledNewArrayLocal()V", registerState);
    }

    @Test
    public void TestFillArrayDataInt() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new int[] { 1, 2, 3, 4, 5 });

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestFillArrayDataInt()V", registerState);
    }

    @Test
    public void TestFillArrayDataChar() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new char[] { 'a', 'b', 'c' });

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestFillArrayDataChar()V", registerState);
    }

    @Test
    public void TestFillArrayDataShort() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new short[] { 100, 200, 5 });

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestFillArrayDataShort()V", registerState);
    }

    @Test
    public void TestFillArrayDataFloat() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new float[] { 1, 2 });

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestFillArrayDataFloat()V", registerState);
    }

    @Test
    public void TestFillArrayDataDouble() {
        SparseArray<Object> registerState;
        registerState = new SparseArray<Object>();
        registerState.put(0, new double[] { 0.1, 1.5 });

        VMTester.executeAndEnsureContextState(CLASS_NAME, "TestFillArrayDataDouble()V", registerState);
    }

}
