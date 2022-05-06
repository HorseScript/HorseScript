# HorseScript.json info

HorseScript.json is a JSON file that contains all the information used by the HorseScript compiler.

## Example

```json
{
  "src": "./src/", /* Source directory to pull files from */
  "exclude": [""], /* Excluded files from the build */

  "compilerOptions": { /* HorseScript Compiler options */

    "type": "minify",             /* Compiler job */
    "out": "./dist/",             /* Output directory */
    "test": true,                 /* Run tests */
    "removeComments": true,       /* Remove comments */
    "removeLines": true,          /* Remove empty lines */

  },
}
```


## Properties

### src : String
The source directory to pull files from.
Use the path that holds the files you want to compile, usually the source code.
A common value would be `./src/`.
```json
  "src": "./src/", /* Source directory to pull files from */
```


### exclude : String[]
The files to exclude from the build.
You can put in individual file paths and entire directories (both and once works!).
Wildcards are not supported.
```json
  "exclude": ["./src/doNotCompile.hscript", "./src/dontCompile/"], /* Excluded files from the build */
```

## Properties.compilerOptions

### type : String
The compiler job, see the list of jobs below.


### out : String


## Type
Supported jobs are: `minify`, `beautify`, `optimize`, `fix`, and `check`.

### minify
```psuedocode
1. Put all the code the directory at .src into one file, other than files in directories and files in .exclude.
2. If the boolean at .compilerOptions.test is true, run tests.
3. Remove all comments, regardless of the boolean at .compilerOptions.removeComments.
4. Remove all empty lines, regardless of the boolean at .compilerOptions.removeLines.
5. Merge all the lines into one line.
6. Save the file to the directory supplied in .compilerOptions.out
```

### beautify
```psuedocode
1. Take in all the code the directory at .src, other than files in directories and files in .exclude.
2. If the boolean at .compilerOptions.test is true, run tests.
3. Put newlines between unseperated lines of code UNLESS the boolean at .compilerOptions.removeLines is true.
4. Add comments with compiler notes to the top of the file, regardless of the boolean at .compilerOptions.removeComments.
5. Add comments to code that the parser could comment, UNLESS the boolean at .compilerOptions.removeComments is true.
6. Save the beautified files to the directory supplied in .compilerOptions.out.
```

### optimize
```psuedocode
1. Take in all the code the directory at .src, other than files in directories and files in .exclude.
2. If the boolean at .compilerOptions.test is true, run tests.
3. Remove all comments, ONLY IF the boolean at .compilerOptions.removeComments is true.
4. Remove all empty lines, ONLY IF the boolean at .compilerOptions.removeLines is true.
5. [Optimize] Inline variables that are only used once, or can be inlined otherwise.
6. [Optimize] More optimization coming soon.
7. Save the file to the directory supplied in .compilerOptions.out
```

### fix
```psuedocode
1. Take in all the code the directory at .src, other than files in directories and files in .exclude.
2. If the boolean at .compilerOptions.test is true, run tests.
3. Remove all comments, ONLY IF the boolean at .compilerOptions.removeComments is true.
4. Remove all empty lines, ONLY IF the boolean at .compilerOptions.removeLines is true.
5. [Fix] Automatically fix common coding flaws.
6. [Fix] Automatically fix errors detected by the tests in step 2.
7. [Fix] More fixes coming soon.
8. Save the file to the directory supplied in .compilerOptions.out
```

### check
```psuedocode
1. If the boolean at .compilerOptions.test is false, exit the entire script, the entire thing is pretty much a big test.
2. Take in all the code the directory at .src, other than files in directories and files in .exclude.
3. Run tests. (.compilerOptions.test is always true by this step).
4. Remove all comments, ONLY IF the boolean at .compilerOptions.removeComments is true.
5. Remove all empty lines, ONLY IF the boolean at .compilerOptions.removeLines is true.
6. [Check] Automatically check for and dump common coding flaws.
7. [Check] Automatically dump errors detected by the tests in step 3.
8. [Check] More checks coming soon?
9. Save the file to the directory supplied in .compilerOptions.out
```



