## Phase 1 P1-06 Frameset and Legacy Browser Pattern Inventory (v1)

Status: Draft (ready for W-LD + QA review)
Version: 1.0
Last Updated: 2026-10-08
Backlog Item: P1-06
Source backlog: [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)
Related baseline: [phase1_p1-01_baseline_test_matrix_v1.md](phase1_p1-01_baseline_test_matrix_v1.md)

### Objective
Catalog frameset layout dependencies, inline event-handler usage, and browser-sniffing patterns that constrain modernization.

### Scope Metrics
- Files with frameset or inline-handler signals: 73
- Files with browser-sniffing signals: 41

### High-Priority Frameset Shells (Runtime Entry Surfaces)
| Priority | File | Pattern | Why It Matters |
|---|---|---|---|
| High | [software_development/TestSuite/LMSRTE/LMSRTEMain.htm](../software_development/TestSuite/LMSRTE/LMSRTEMain.htm) | Nested frameset | Primary LMS conformance shell with instruction/log/control frame coupling. |
| High | [software_development/TestSuite/scoRTE/SCORTEMain.htm](../software_development/TestSuite/scoRTE/SCORTEMain.htm) | Frameset with onload navigation | Primary SCO utility shell and log pairing. |
| High | [software_development/TestSuite/contentpackage/ContentPackageMain.htm](../software_development/TestSuite/contentpackage/ContentPackageMain.htm) | Frameset with onload navigation | Primary Content Package shell. |
| High | [software_development/TestSuite/contentpackage/ManifestUtilityMain.htm](../software_development/TestSuite/contentpackage/ManifestUtilityMain.htm) | Frameset with onload navigation | Primary Manifest utility shell. |
| Medium | [software_development/TestSuite/checksum/ChecksumTest.htm](../software_development/TestSuite/checksum/ChecksumTest.htm) | Frameset shell | Utility flow shell. |
| Medium | [software_development/TestSuite/Log.htm](../software_development/TestSuite/Log.htm) | Popup + applet-managed view | Shared logging UI dependency for multiple flows. |

### Additional Frameset Wrapper Dependencies
| Priority | File | Pattern | Notes |
|---|---|---|---|
| High | [software_development/TestSuite/scoRTE/SCOWrapper.htm](../software_development/TestSuite/scoRTE/SCOWrapper.htm) | Frameset staged launch | Controls SCO launch lifecycle. |
| High | [software_development/TestSuite/contentpackage/CP_SCOWrapper.htm](../software_development/TestSuite/contentpackage/CP_SCOWrapper.htm) | Frameset staged launch | CP path SCO launch coupling. |
| Low | [software_development/TestSuite/CTS_Readme/main.html](../software_development/TestSuite/CTS_Readme/main.html) | Documentation frameset | Non-runtime docs path but still legacy layout. |

### Inline Event Handler Concentration (Representative)
| Priority | File | Representative Pattern | Notes |
|---|---|---|---|
| High | [software_development/TestSuite/scoRTE/SCORTEInstructions.htm](../software_development/TestSuite/scoRTE/SCORTEInstructions.htm) | body onload/onunload, many button onclick handlers | Core runtime orchestration page with dense inline behavior. |
| High | [software_development/TestSuite/contentpackage/ContentPackageInstructions.htm](../software_development/TestSuite/contentpackage/ContentPackageInstructions.htm) | body onload/onunload plus staged onclick flow | Core CP control page. |
| High | [software_development/TestSuite/contentpackage/ManifestUtilityInstructions.htm](../software_development/TestSuite/contentpackage/ManifestUtilityInstructions.htm) | onload/onunload and step controls | Core manifest control page. |
| High | [software_development/TestSuite/LMSRTE/LMSControls.htm](../software_development/TestSuite/LMSRTE/LMSControls.htm) | multiple control button onclick handlers | Primary LMS state-control interaction point. |
| Medium | [software_development/TestSuite/checksum/checksumBody.htm](../software_development/TestSuite/checksum/checksumBody.htm) | onload and form/button onclick handlers | Utility interaction path. |
| Medium | [software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTest.htm](../software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTest.htm) | dynamic HTML with onclick-based controls | Representative of many course resource pages. |

### Browser-Sniffing and Compatibility Pattern Inventory
| Priority | File | Pattern | Notes |
|---|---|---|---|
| High | [software_development/TestSuite/scripts/BrowserDetect.js](../software_development/TestSuite/scripts/BrowserDetect.js) | DetectBrowser with IE and Netscape flags via userAgent parsing | Central browser-branch logic used broadly. |
| High | [software_development/TestSuite/scripts/EmulationCode.js](../software_development/TestSuite/scripts/EmulationCode.js) | IE emulation/compat helpers | Referenced by key runtime pages. |
| High | [software_development/TestSuite/scoRTE/SCORTEInstructions.htm](../software_development/TestSuite/scoRTE/SCORTEInstructions.htm) | DetectBrowser branches and setIsBrowserNetscape calls | Core SCO flow browser dependence. |
| High | [software_development/TestSuite/contentpackage/ContentPackageInstructions.htm](../software_development/TestSuite/contentpackage/ContentPackageInstructions.htm) | IE versus non-IE applet path branching | Core CP flow browser dependence. |
| High | [software_development/TestSuite/LMSRTE/LMSControls.htm](../software_development/TestSuite/LMSRTE/LMSControls.htm) | conditional object embedding comments and browser path split | Core LMS flow browser dependence. |
| Medium | [software_development/TestSuite/LMSRTE/Courses/scripts/lmsrtefunctions.js](../software_development/TestSuite/LMSRTE/Courses/scripts/lmsrtefunctions.js) | DetectBrowser usage and IE branch logic | Course package support behaviors. |

### Pattern Families to Replace in Phase 5
1. Frameset navigation shells and nested frame coupling.
1. Inline DOM event attributes (onload, onclick, onunload) used as control flow.
1. userAgent and IE/Netscape branch logic.
1. Conditional legacy object-embedding structures.

### Migration Priority Guidance
1. Priority 1: Runtime entry shells and instruction/control pages (LMSRTEMain, SCORTEMain, ContentPackageMain, ManifestUtilityMain, instruction pages, LMSControls).
1. Priority 2: Wrapper and shared utility pages (SCOWrapper, CP_SCOWrapper, Log, checksum pages).
1. Priority 3: Course resource pages and readme/documentation shells.

### Evidence and Method
- Search patterns used:
- frameset tags
- inline on* handlers
- window.open usage in control pages
- BrowserDetect and EmulationCode script references
- IE/Netscape user-agent branching tokens

### Version History
- v1.0 (2026-10-08): Initial frameset, inline-handler, and browser-pattern inventory with migration priority.
