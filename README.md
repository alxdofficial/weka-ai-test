# Fashion design classification algorithm


this software uses machine learning to categorize clothing into design-styles. each garment is described using 15 attributes. the program includes a default dataset, and the user is able to create datasets of their own using this program. then the program uses the data to trian a machine learning algorithm based on naive bayes. then users can enter more clothing items that havent been clasified yet, and the machine learning algorith will predict what design-style it is.
this software is dedicated to a friend of mine who is looking to improve her style but has not enough time shopping. but this software can be easily generalized to include more design-style to suit more users. this is also a chance for me to learn about machine learning so thats why im doing it.

## user stories 


- landing page with explanation of what each parameter means and how to use
- input various parameters of a garment
- user can create a set of data entries 
- user can lable each data entry with a design-style
- user can train a machine learning model based on their entries
- user can enter more entries that have no lables and let the machine learning algorithm predict their style
- output page show the garments belonging to each category.

### how it works

1. each clothing has 15 attributes used to describe it, including one classification attribute. the classfification attribute is what the ML algorithm will try to predict. all atributes except for numOfColors is of type nominal, which means spelling differences between 2 entries means two different attributes.
2. the user inputs as many garments as possible and labels each with its classfication, or the garment's design style. the types of attributes are fixed, so there is only 15 predefined parameters like length, thickness, and etc. but the entries for each parameter can be anything the user inputs. the more variation in parameters, the more entries should be inputted for a accurate sample.
3. the program writes an arff file, which is what weka, the machine learning library prefers. 
4. the program uses naive bayes, which calculates the product of the probilities of each attribute belonging to each classificiation, and takes the largest value. there is also a default model called "default_garments.arff" that divides clothes into 3 styles, rustic, urban, and minimalist.
5. the user now inputs any number of new items without labeling the design-style. the user chooses a pretrained model by inputting the filename, which looks like "aX39.arff", or "default_garments.arff". 
6. the chosen model classifies the unlabeled entries and prints the answer to the screen.

### clothing parameters

this program allows for double standards instead of absolute values in each attribute. what that means is that instead of taking a caliper to measure the thickness of a garment, whether a garment is thick or thin also depends on what type of clothing it is. for example, a long sleeve sweater can be labled as "warm" compared to a t-shirt. but even though a rain jacket is thicker than sweater, it is labled as "mid" because it is not as warm as other garments of its type, such as a puffer jacket. this makes sense because an athletic style under shirt focuses on being as light as possible, while a fashionable puffer jacket doesnt try to be extremely material effecient. this design choice is what ultimately contributes to the style of the garment, not the physical warmth it provides. similarly, a mini dress can be longer than a leather jacket, but both items are labeled as short compared to other garments of their types. it only makes sense to compare two dresses with each other and two jackets with each other to determine style. you cant compare the length a dress to a jacket because they are entirely different types. so when the user is gathering data, one should take into the account of the type of garment in question and remap the values relatively.  

** IMPORTANT: in order to use 'default_garments.arff' to classify new items, your new items must only have attribute values that exist in the training data set. for example, new colors like magenta or orange is undefined because the original dataset didn't have them. next to each attribute, there will also be a list of available options. **


1. color                   (one of {black, beige, blue, white, pink, red, grey, yellow, green})
2. length                  (one of {short, mid, long})
3. thickness               (one of {thin, mid, thick})
4. warmth                  (one of {low, mid, high})
5. fabric stitch density   (one of {low, mid, high})
6. shiny?                  (one of {yes, no})
7. body contouline         (one of {flowy, box, hourglass})
8. num of colors           int
9. stiffness               (one of {stretch, mid, stiff})
10. water resistance       (one of {yes, no})
11. material               (one of {cotton, wool, synthetic, denim})
12. fit                    (one of {loose, mid, tight})
13. pattern                (one of {solid, lines, faded, grid, floral, graphics})
14. contrast               (one of {low, high})
15. classification         (one of {rustic, urban, minimalist})

of course, if you were to build your own machine learning model, you may use any enumeration of values for the attributes.



example log:

Log:
Tue Nov 23 16:37:59 PST 2021
new model entry created

Tue Nov 23 16:38:10 PST 2021
new arffwriter created

Tue Nov 23 16:38:10 PST 2021
new arff file is called default_garments.arffuz4f.arff

Tue Nov 23 16:38:10 PST 2021
new empty arff file created

Tue Nov 23 16:38:10 PST 2021
arff file headers setup

Tue Nov 23 16:38:10 PST 2021
done writing entries

Tue Nov 23 16:38:10 PST 2021
arff file writing complete

Tue Nov 23 16:39:54 PST 2021
new classifying entry created

Tue Nov 23 16:40:06 PST 2021
new MLAlgorithm created

Tue Nov 23 16:40:06 PST 2021
naive bayes successfully found data in filepath

Tue Nov 23 16:40:07 PST 2021
naive bayes construction success

Tue Nov 23 16:40:07 PST 2021
cross checking complete and summary text generated

Tue Nov 23 16:40:07 PST 2021
classi-entry labeld

Tue Nov 23 16:40:07 PST 2021
classification results successfully converted to list of classi-entries