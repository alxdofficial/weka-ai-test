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
    private List<Entry> categorizationEntries;


    public MLAlgorithm() {
        categorizationEntries = new ArrayList<>();
        EventLog.getInstance().logEvent(new Event("new MLAlgorithm created"));
    }

//    MODIFIES: this
//    EFFECTS: add to the list of entrys used for categorization
    public void addToCatEntry(List<Entry> loe) {
        categorizationEntries.addAll(loe);
        EventLog.getInstance().logEvent(new Event("finished adding classi-entries to mlalgorithm"));
    }



    //    EFFECTS: makes predictions for inputed list of data entries using ML model specified by filename
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public String naiveBayesClassification(String filename, List<Entry> loe) throws Exception {
        DataSource data = new DataSource(filename);
        EventLog.getInstance().logEvent(new Event("naive bayes successfully found data in filepath"));
        // Create dataset instances
        Instances datasetInstances = data.getDataSet();
        datasetInstances.setClassIndex(datasetInstances.numAttributes() - 1);
        //new naive bayes
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(datasetInstances);
        EventLog.getInstance().logEvent(new Event("naive bayes construction success"));
        //cross validation and sumary printing
        Instances test = datasetInstances;
        Evaluation eval = new Evaluation(test);
        eval.evaluateModel(nb,test);
        String qualityReport = eval.toSummaryString("\nResults\n======\n", false);
        EventLog.getInstance().logEvent(new Event("cross checking complete and summary text generated"));

        List<Entry> catResults = new ArrayList<>();

// create instances of the unlabled entries and assigns them to the dataset of the trained ML model
        for (Entry e : loe) {
            Instance i = new DenseInstance(15);
            i.setDataset(datasetInstances);
            i.setValue(0,e.color);
            i.setValue(1,e.length);
            i.setValue(2,e.thickness);
            i.setValue(3,e.warmth);
            i.setValue(4,e.fabricStitchDensity);
            i.setValue(5,e.shiny);
            i.setValue(6,e.numColors);
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
            catResults.add(e);
        }

        EventLog.getInstance().logEvent(new Event("classification results successfully"
                + " converted to list of classi-entries"));

        this.categorizationEntries = catResults;
        return qualityReport;

    }

    //    EFFECTS: get entries about to be used for categorization
    public List<Entry> getCatEntries() {
        return categorizationEntries;
    }


}