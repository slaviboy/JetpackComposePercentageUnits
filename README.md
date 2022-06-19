# JetpackComposePercentageUnits

<a align="center" href="https://slaviboy.github.io/Compose-Icons-Site/">
    <img src="https://github.com/slaviboy/RepositoryImages/blob/main/lib/percentage_units_home.png" alt="Image" />
</a>

## Dependency
Step 1.
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.slaviboy:JetpackComposePercentageUnits:1.0.0'
	}


## About
The library allows you to use use the device Width and Height as meassuring units, that can be used to set the Modifier properties. The advantages of using ```dw(device width), dh (device height)``` values instead of dp is that you can scale the content of the Composable components accourding to the current device size.

To initialize the size inside your MainActivity onCreate method call the method **initSize()**, otherwise you would get an *java.lang.IllegalArgumentException: Cannot round NaN value.* error!

```kotlin
class MainActivity : ComponentActivity() {
 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // init device width and height
        initSize() 

        setContent { 
	
            // your UI here
	    Text(
            text = "Hello",
            fontSize = 0.04.sh,
            color = Color.Green, 
            modifier = Modifier
                .offset(x = 0.07.dw, y = 0.2.dh)
            )
        }
    }
}
```

![alt text](https://github.com/slaviboy/RepositoryImages/blob/main/image2.png?raw=true)
