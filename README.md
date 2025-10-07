# Image Explorer App

A small Android Image Explorer app built with Jetpack Compose that demonstrates modern Android architecture patterns including Repository pattern, ViewModel with StateFlow, and Dependency Injection with Hilt.

## Features

- Displays images with titles in a clean, centered layout
- Next button to navigate through images with wrap-around functionality
- Proper image scaling with cropped fit
- Accessibility support with content descriptions

## Architecture

The app follows the recommended Android app architecture with proper separation of concerns:

### Data Layer
- **ImageItem**: Data model with type-safe annotations (`@StringRes`, `@DrawableRes`)
- **ImageDataSource**: Static data source containing 4 sample images
- **ImageRepository**: Interface and implementation for data access

### UI Layer
- **ImageExplorerUiState**: Immutable UI state data class
- **ImageExplorerViewModel**: Manages UI state with StateFlow, survives configuration changes
- **ImageExplorerScreen**: Jetpack Compose UI with Column layout

### Dependency Injection
- **Hilt**: Complete DI setup with @HiltAndroidApp, @AndroidEntryPoint, @Module
- **Repository Module**: Provides ImageRepository binding with @Singleton scope

## Technical Implementation

### State Management
- Uses StateFlow for reactive UI updates
- Private mutable state with public read-only exposure
- ViewModelScope for coroutine management

### Repository Pattern
- Abstraction between ViewModel and data sources
- Centralized data access with wrap-around logic
- Interface-based design for testability

### UI Components
- Jetpack Compose Column layout with center alignment
- Image with ContentScale.Crop for proper aspect ratio
- Material3 styling with proper padding

### Testing
- Unit tests for ViewModel state transitions
- Fake repository implementation for testing
- Tests for initial state, next navigation, and wrap-around behavior
- Proper coroutine testing setup with TestDispatcher

## Project Structure

```
app/src/main/java/com/example/myimageapp/
├── data/
│   ├── ImageItem.kt                    # Data model with annotations
│   └── ImageDataSource.kt              # Static data source
├── repository/
│   ├── ImageRepository.kt              # Repository interface
│   └── ImageRepositoryImpl.kt          # Repository implementation
├── ui/
│   ├── ImageExplorerUiState.kt         # UI state data class
│   ├── ImageExplorerViewModel.kt       # ViewModel with StateFlow
│   └── ImageExplorerScreen.kt          # Compose UI screen
├── di/
│   └── RepositoryModule.kt             # Hilt dependency injection module
├── MyImageApp.kt                       # Application class with @HiltAndroidApp
└── MainActivity.kt                     # Activity with @AndroidEntryPoint
```

## Dependencies

- **Jetpack Compose**: Modern UI toolkit
- **Hilt**: Dependency injection framework
- **ViewModel**: Architecture component for UI state
- **StateFlow**: Reactive state management
- **Material3**: Material Design components

## Testing

The app includes comprehensive unit tests:

```bash
./gradlew test
```

Tests verify:
- Initial UI state initialization from repository
- Next button updates state correctly
- Wrap-around functionality after last item
- ViewModel state transitions

## Building

To build the debug APK:

```bash
./gradlew assembleDebug
```

## Requirements Met

✅ **Image Explorer Screen**: Displays image, title, and next button  
✅ **Functional Requirements**: Launch display, next navigation, wrap-around, image scaling  
✅ **UiState**: Immutable data class with proper annotations  
✅ **ViewModel**: StateFlow exposure, internal index management, repository initialization  
✅ **Repository Pattern**: Interface abstraction, no direct data source access  
✅ **Static Data Source**: 4+ items with type-safe annotations  
✅ **Dependency Injection**: Complete Hilt setup with @HiltViewModel, @Inject, @Module  
✅ **UI Components**: Column layout with Image, Text, Button  
✅ **Unit Tests**: ViewModel next-state verification  
✅ **Code Quality**: Idiomatic Kotlin/Compose, separation of concerns  

## Sample Images

The app includes 4 sample images created as vector drawables:
- Majestic Mountains
- Peaceful Ocean  
- Green Forest
- Golden Desert

Each image is properly scaled and includes accessibility content descriptions.