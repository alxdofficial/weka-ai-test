package model;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.Prediction;
import weka.core.*;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;
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


    public List<Entry> naiveBayesClassification(String filename, List<Entry> loe) throws Exception {
        DataSource data = new DataSource(filename);

        // Create dataset instances
        Instances datasetInstances = data.getDataSet();
        datasetInstances.setClassIndex(datasetInstances.numAttributes() - 1);
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(datasetInstances);
        Instances test = datasetInstances;
        Evaluation eval = new Evaluation(test);
        eval.evaluateModel(nb,test);
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));



        List<Entry> answer = new ArrayList<>();

        for (Entry e : loe) {
            Instance i = new DenseInstance(15);
            i.setDataset(datasetInstances);
            i.setValue(0,e.color);
            i.setValue(1,e.length);
            i.setValue(2,e.thickness);
            i.setValue(3,e.warmth);
            i.setValue(4,e.fabricStitchDensity);
            i.setValue(5,e.shiny);
            i.setValue(6,e.numClors);
            i.setValue(7,e.bodyLine);
            i.setValue(8,e.stiffness);
            i.setValue(9,e.waterResistance);
            i.setValue(10,e.material);
            i.setValue(11,e.fit);
            i.setValue(12,e.pattern);
            i.setValue(13,e.contrastVibrancy);
            i.setValue(14,"minimalist");
            double clsLabel = nb.classifyInstance(i);

            i.setClassValue(clsLabel);
            String clsLabelString = i.stringValue(datasetInstances.classAttribute());
            e.label(clsLabelString);
            answer.add(e);
        }

        return answer;
    }

    public List<Entry> getCatEntries() {
        return categorizationEntries;
    }


}