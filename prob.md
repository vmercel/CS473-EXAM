# Exam Questions

## Question 1: Programming Concepts Matching

**Match the following concepts to their definitions:**

A. Language features that prevent NPEs: non-nullable types, the safe call ?., the Elvis ?:, and the not-null assertion !!.

B. Providing a new implementation of an open/abstract function in a subclass using the override keyword

C. A static-like holder inside a class; exactly one per class; members accessed via the class name; cannot have constructor parameters.

D. A class-level singleton created on first access; no constructor parameters; often used for global config or utilities. Members accessed via the object name.

E. A contract type listing functions/properties a class must implement; implemented with : TypeName; can have default method bodies.

F. Reusing behavior by extending an open class with : ParentClass(...); expresses an is-a relationship.

**Options:**
1. Null safety
2. Inheritance  
3. Interface
4. Method overriding
5. object
6. companion object

---

## Question 2: Android Image Explorer App

**Build a small Image Explorer app screen in Android Jetpack Compose that shows:**

• An Image
• A Text title below it  
• A Button to advance to the next image/title (with wrap-around)

**BONUS (+3 points):** Apply Dependency Injection (Hilt) in your solution.

Inject your ImageRepository into the ImageViewModel (use @HiltViewModel, @Inject constructor, a @Module + @InstallIn(SingletonComponent::class) provider, and @AndroidEntryPoint on the host Activity).

[Download Sample Images](Download%20Sample%20Images)

### Functional Requirements

1. On launch, the screen displays the first image and its title from a data source.
2. Tapping Next advances to the next item; after the last item, it wraps to the first.
3. The image must fill the width and keep a reasonable aspect ratio with a cropped fit.
4. The image's content description must use the same title shown in Text (for accessibility).

### Architecture & Constraints (mandatory)

• **UiState:**
  ○ Create an immutable UiState data class that represents everything the UI needs (e.g., current image resource id, current title resource id, etc).
  ○ Do not store business logic or mutable fields in UiState.

• **ViewModel:**
  ○ Expose the state as a StateFlow of UiState.
  ○ Hold the current index internally and provide a method to go to the next item.
  ○ Initialize UiState from the repository.
  ○ Do not expose mutable state; use a private mutable flow and public read-only flow.

• **Repository Pattern:**
  ○ Define a Repository interface that provides access to items and a way to derive the next item by index (e.g., getAll() and a "next" function of your choice).
  ○ Implement the interface in a class that reads from the static data source.
  ○ The UI and ViewModel must not access the data source directly—only through the repository.

• **Static Data Source:**
  ○ Define a static list of items (at least 4).
  ○ Each item contains: a string resource id for the title and a drawable resource id for the image.
  ○ Use type-safe annotations in your model (string/drawable resource annotations).

• **UI (Compose):**
  ○ Use a Column containing Image, Text, and Button.
  ○ Collect state from the ViewModel and render strictly from UiState.

### What You Submit

1. Your project (Git repo link)
2. A README file with the following:
   ○ One screenshot of the running app showing an image + title.
   ○ Test report screenshot

### Grading Rubric (36 pts)

• **Image explorer screen (4 points)**
  ○ Images are fit properly (3 points)
  ○ Title is aligned center horizontally (1 points)

• **ViewModel & StateFlow (8 pts)**
  ○ Proper StateFlow exposure (read-only) (3)
  ○ Correct initialization of UiState from repository (2)
  ○ Next logic updates UiState (3)

• **UiState (2 pts)**
  ○ Clean immutable UiState (2)

• **Repository Pattern (10 pts)**
  ○ No direct data source access from UI/ViewModel (5)
  ○ Correct wrap-around via repository (5)

• **Static Data Source (5 pts)**
  ○ Uses resource-typed model (string/drawable) (3)
  ○ At least 4 items (2)

• **Unit Tests (4 pts)**
  ○ ViewModel next-state (4)

• **Code Quality (3 pts)**
  ○ Idiomatic Kotlin/Compose, separation of concerns, readability

### UX Details

• Center alignment is preferred; add reasonable padding.
• Use contentScale appropriate for photos (cropped fit).

### Testing (short & focused)

• Verify that calling getNext() once after initialization updates UiState from the first item to the second item