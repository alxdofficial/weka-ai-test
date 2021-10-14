package model;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Prediction;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.lang.Character;


public class MLAlgorithm {
//    private List<EntryM> modelEntries;
    private List<Entry> categorizationEntries;


    public MLAlgorithm() {
//        modelEntries = new ArrayList<>();
        categorizationEntries = new ArrayList<>();

    }

//    public void addToModelEntry(List<EntryM> loe) {
//        modelEntries.addAll(loe);
//    }

    public void addToCatEntry(List<Entry> loe) {
        categorizationEntries.addAll(loe);
    }

    public void naiveBayesClassification(String filename) throws Exception {
        DataSource irisData = new DataSource(filename);

        // Create dataset instances
        Instances datasetInstances = irisData.getDataSet();
        datasetInstances.setClassIndex(datasetInstances.numAttributes() - 1);
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(datasetInstances);
        Instances test = datasetInstances;
        Evaluation eval = new Evaluation(test);
        eval.evaluateModel(nb,test);
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));
    }


}