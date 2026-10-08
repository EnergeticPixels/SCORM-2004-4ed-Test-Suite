## Phase 1 P1-05 Applet Touchpoints Inventory (v1)

Status: Draft (ready for TL + J-LD review)
Version: 1.0
Last Updated: 2026-10-08
Backlog Item: P1-05
Source backlog: [phase1_sprint-planning_backlog.md](phase1_sprint-planning_backlog.md)
Related baseline: [phase1_p1-01_baseline_test_matrix_v1.md](phase1_p1-01_baseline_test_matrix_v1.md)

### Objective
Catalog Java applet dependencies and JS bridge touchpoints that block modern-browser execution and drive runtime replacement scope.

### Inventory Scope
- Source tree: [software_development/src/org/adl](../software_development/src/org/adl)
- Runtime HTML/JS tree: [software_development/TestSuite](../software_development/TestSuite)
- Detection patterns used: applet object embedding, Java plugin MIME/type usage, JSObject LiveConnect calls, Applet registration patterns.

### Scope Metrics
- Applet-related files identified: 39
- Java sources with applet or JSObject bridge behavior: 9 primary classes

### Primary Java Applet and LiveConnect Touchpoints
| Priority | Area | File | Touchpoint Type | Notes |
|---|---|---|---|---|
| High | Logging bridge | [software_development/src/org/adl/logging/LogManagerInterfaceApplet.java](../software_development/src/org/adl/logging/LogManagerInterfaceApplet.java) | Applet + JSObject | Core log manager bridge used by log UI. |
| High | LMS control runtime | [software_development/src/org/adl/testsuite/rte/lms/LMSTestApplet.java](../software_development/src/org/adl/testsuite/rte/lms/LMSTestApplet.java) | Applet + JSObject + AppletList | Primary LMS applet driver. |
| High | SCO API runtime | [software_development/src/org/adl/testsuite/rte/sco/SCORTEDriver.java](../software_development/src/org/adl/testsuite/rte/sco/SCORTEDriver.java) | Applet + JSObject + AppletList | Registers APIImplementation and drives SCO runtime test flow. |
| High | Content Package runtime | [software_development/src/org/adl/testsuite/contentpackage/ContentPackageDriver.java](../software_development/src/org/adl/testsuite/contentpackage/ContentPackageDriver.java) | Applet + JSObject + AppletList | Core CP and Manifest utility driver path. |
| High | Checksum utility runtime | [software_development/src/org/adl/testsuite/checksum/PackageChecksumDriver.java](../software_development/src/org/adl/testsuite/checksum/PackageChecksumDriver.java) | Applet + JSObject + AppletList | Utility execution path still applet-backed. |
| Medium | LMS-to-SCO bridge | [software_development/src/org/adl/testsuite/rte/lms/comm/LMSTestSCOApplet.java](../software_development/src/org/adl/testsuite/rte/lms/comm/LMSTestSCOApplet.java) | Applet + JSObject | Embedded within LMS course resource pages. |
| Medium | LMS command execution | [software_development/src/org/adl/testsuite/rte/lms/util/Command.java](../software_development/src/org/adl/testsuite/rte/lms/util/Command.java) | JSObject call dispatch | LiveConnect call site for LMS API command execution. |
| Medium | SCO test orchestration | [software_development/src/org/adl/testsuite/rte/sco/SCORTETester.java](../software_development/src/org/adl/testsuite/rte/sco/SCORTETester.java) | JSObject window coupling | Depends on APIImplementation applet window reference. |
| Low | Summary logging helper | [software_development/src/org/adl/logging/SummaryLogWriter.java](../software_development/src/org/adl/logging/SummaryLogWriter.java) | JSObject log bridge | Secondary bridge path tied to applet-backed logging. |

### Primary HTML Applet Embedding Hotspots
| Priority | File | Embedded Applet/Class | Notes |
|---|---|---|---|
| High | [software_development/TestSuite/LMSRTE/LMSControls.htm](../software_development/TestSuite/LMSRTE/LMSControls.htm) | LMSTestApplet | Top-level LMS control frame applet host. |
| High | [software_development/TestSuite/scoRTE/SCORTEInstructions.htm](../software_development/TestSuite/scoRTE/SCORTEInstructions.htm) | SCORTEDriver as APIImplementation | Main SCO test control and API applet embedding. |
| High | [software_development/TestSuite/contentpackage/ContentPackageInstructions.htm](../software_development/TestSuite/contentpackage/ContentPackageInstructions.htm) | ContentPackageDriver and SCORTEDriver | Dual applet embedding for CP + SCO logic. |
| High | [software_development/TestSuite/contentpackage/ManifestUtilityInstructions.htm](../software_development/TestSuite/contentpackage/ManifestUtilityInstructions.htm) | ContentPackageDriver | Manifest utility applet embedding. |
| High | [software_development/TestSuite/Log.htm](../software_development/TestSuite/Log.htm) | LogManagerInterfaceApplet | Shared logging applet host. |
| Medium | [software_development/TestSuite/checksum/checksumBody.htm](../software_development/TestSuite/checksum/checksumBody.htm) | PackageChecksumDriver | Checksum utility applet host. |
| Medium | [software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_API/resources/APIRTETest1.htm](../software_development/TestSuite/LMSRTE/Courses/LMSTestPackage_API/resources/APIRTETest1.htm) | LMSTestSCOApplet | Representative of many LMS package resource pages. |
| Medium | [software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTest.htm](../software_development/TestSuite/LMSRTE/Courses/SCODepot/SequencingTest.htm) | LMSTestSCOApplet | Representative of SCODepot sequencing resources. |

### Repeating Legacy Embedding Pattern
Common repeated constructs found across utility and course resource pages:
- application/x-java-applet MIME type
- classid value for Java plugin and CLSID fallback
- MAYSCRIPT enabled Java-to-JS bridge
- split paths for IE versus non-IE object embedding

### Migration Impact Summary
- Applet removal is a critical-path prerequisite for modern browser support.
- Replacement must preserve:
- log writing semantics
- LMS API command exchange behavior
- SCO launch and lifecycle control
- Content package and manifest validation flow behavior

### Proposed Replacement Sequencing
1. Replace high-priority host pages and Java classes first (LMSControls, SCORTEInstructions, ContentPackageInstructions, Log).
1. Introduce a service facade for current applet responsibilities while preserving baseline artifact equivalence.
1. Migrate medium-priority package resource embeddings by template/pattern refactor to reduce duplicated effort.

### Evidence and Method
- Search patterns used:
- application/x-java-applet
- classid=java:
- MAYSCRIPT
- netscape.javascript.JSObject
- AppletList.register

### Version History
- v1.0 (2026-10-08): Initial applet dependency inventory with prioritized Java and HTML touchpoints.
